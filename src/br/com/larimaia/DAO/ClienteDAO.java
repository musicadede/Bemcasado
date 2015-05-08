
package br.com.larimaia.DAO;

import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;


public class ClienteDAO {
    Connection conexao;
    
    public ClienteDAO(){
        conexao= ConexaoUtil.getConnection();
    }
    
    public List<Cliente> buscarCliente(){
        String sql= "SELECT * FROM cliente ORDER by nome ";
        
        try {
            PreparedStatement preparadorSql= conexao.prepareStatement(sql);
            ResultSet resultado = preparadorSql.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            
            while (resultado.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                clientes.add(cliente);
            }
            
            preparadorSql.close();
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Cliente buscarCliente(int id){
        String sql= "SELECT * FROM cliente ORDER by nome ";
        
        try {
            PreparedStatement preparadorSql= conexao.prepareStatement(sql);
            ResultSet resultado = preparadorSql.executeQuery();
            Cliente cliente = new Cliente();
            
            while (resultado.next()){
                cliente.setId(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
            }
            
            preparadorSql.close();
            return cliente;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
     public void salvar (Cliente cli){
        if(cli.getId() == null){
            Cadastrar(cli);
        }else{
            alterar(cli);
        }
        
    }
    
    private void Cadastrar(Cliente cli) {
        String sql = "INSERT INTO cliente(idcliente,nome,telefone,email) VALUES(?,?,?,?)";
        TipoEvento tipoevento = new TipoEvento();
        
        try {
           PreparedStatement preparadorsql= conexao.prepareStatement(sql);
           
           preparadorsql.setString(1, "default");
           preparadorsql.setString(2, cli.getNome());
           preparadorsql.setString(3, cli.getTelefone());
           preparadorsql.setString(4, cli.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void alterar(Cliente cli) {
       String sql = "UPDATE cliente SET nome=?,telefone=?,email=?"; 
        
        try {
           PreparedStatement preparadorsql= conexao.prepareStatement(sql);
           preparadorsql.setString(1, cli.getNome());
           preparadorsql.setString(2, cli.getTelefone());
           preparadorsql.setString(3, cli.getEmail());
           
        } catch (SQLException ex) {
            Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir (int id){
        
        String sql = "DELETE  FROM cliente WHERE idcliente=?";
        
        try {
            PreparedStatement preparadorsql = conexao.prepareStatement(sql);
            preparadorsql.setInt(1, id);
            preparadorsql.execute();
            preparadorsql.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
          
}
