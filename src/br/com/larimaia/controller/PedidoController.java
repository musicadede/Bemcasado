
package br.com.larimaia.controller;

import br.com.larimaia.DAO.PedidoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PedidoController implements Initializable {
    
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
        
    }    
    
}
