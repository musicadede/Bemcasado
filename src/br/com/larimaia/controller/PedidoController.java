
package br.com.larimaia.controller;


import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.DAO.ProdutoDAO;
import br.com.larimaia.DAO.TipoEventoDAO;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.ClienteController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PedidoController implements Initializable {
    @FXML 
    private ComboBox<Cliente> comboBoxClientes;
    
    @FXML 
    private ComboBox<Produto> comboBoxProduto;
    
    @FXML 
    private ComboBox<TipoEvento> comboBoxTipo;
    
    @FXML
    private Label label;
    
    
    @FXML  
    private void salvar (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarPorId(1);
        
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
        ClienteDAO cliDAO = new ClienteDAO();
         ObservableList<Cliente> 
                relacaoClientes = FXCollections.observableArrayList( cliDAO.buscarCliente());
         comboBoxClientes.setItems(relacaoClientes);
         
        ProdutoDAO pdao = new ProdutoDAO();
        ObservableList<Produto> 
                relacaoProduto = FXCollections.observableArrayList( pdao.buscaProduto());
         comboBoxProduto.setItems(relacaoProduto);
         
         TipoEventoDAO tipodao = new TipoEventoDAO();
        ObservableList<TipoEvento> 
                relacaoTipoevento = FXCollections.observableArrayList( tipodao.buscarTodosOsTiposDeEventos());
         comboBoxTipo.setItems(relacaoTipoevento);
         
       
    }  
    
    @FXML
    public void buscarNomeClientes(){
        
        
    }
    
    
}
