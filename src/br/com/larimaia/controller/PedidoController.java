
package br.com.larimaia.controller;


import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.model.Cliente;
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
    private ComboBox<String> comboBoxClientes;
    
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
        List<String> clientes = cliDAO.buscarNomeCliente();
         ObservableList<String> 
                relacaoClientes = FXCollections.observableArrayList( clientes );
         comboBoxClientes.setItems(relacaoClientes);
       
        
    }   
    @FXML
    public void buscarNomeClientes(){
        
        
    }
    
    
}
