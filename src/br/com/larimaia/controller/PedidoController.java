
package br.com.larimaia.controller;


import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.PedidoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PedidoController implements Initializable {
    PedidoService pedidoService;
    Pedido pedido;
    
    @FXML
    private TextField localContrato;
    
    @FXML
    private DatePicker dataPedido;
    
    @FXML 
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private TextField cerimonial;
    
    
    @FXML 
    private ComboBox<Produto> comboBoxProduto;
    
    @FXML 
    private ComboBox<TipoEvento> comboBoxTipo;
    
    
    @FXML
    private TextField hora;
    
    @FXML
    private TextField qtdproduto;
    
    @FXML
    private TextField valorProduto;
    
    @FXML
    private Button salvar;
    
    @FXML
    private Button adicionar;
    
    
    @FXML  
    private void salvar (ActionEvent e){
//        PedidoDAO buscar = new PedidoDAO();
//        buscar.buscarPorId(1);
//       pedido.set
            
        try {
            pedidoService.salvar(null);
        } catch (Exception ex) {
        
        }
        
        
    }
    
    @FXML  
    private void buscarPedido (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarTodosPedidos();
        
    }
    
    @FXML  
    private void buscarPedidoPorId (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarPorId(1);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         comboBoxClientes.setItems(PedidoService.buscarClientes());
         comboBoxProduto.setItems(PedidoService.buscarProdutos());
         comboBoxTipo.setItems(PedidoService.buscarTipoEventos());
    }  
    
    @FXML
    public void adicionarNaTabela(ActionEvent e){
        
        
    }
    
    
    
}
