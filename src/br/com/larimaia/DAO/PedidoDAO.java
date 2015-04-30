

package br.com.larimaia.DAO;

import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PedidoDAO {
    // Criando variavel do tipo Connection para receber a conexao com o banco
    
    Connection conexao;
    
    // Criando metodo que busca pedidos pelo ID
    
    public Pedido buscaPorId (Integer id) throws SQLException{
        // Criando variavel para receber um comando sql que realiza um select no banco 
        
        String sql = "SELECT * FROM pedido WHERE id=?";
        PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
        preparadorSQL.setInt(1, id);
        
        // Recebendo resultado da consulta.
        
        ResultSet resultado = preparadorSQL.executeQuery();
        
        if(resultado.next()){
            // Instanciando Pedido.
            Pedido ped = new Pedido();
            
            // Inserindo os valores retornados para "resultado" em ped.
            ped.setId(id);
            ped.setOrigemPedido(resultado.getString("origemPedido"));
            ped.setDataPedido(resultado.getDate("dataPedido"));
            
            String consultacliente= "select id  from cliente where id= ?(id da tabela) "
            
            String nomecliente = resultado.getString("Cliente_nome");
           
            
                    
            ped.setCliente(nomecliente);
            
            
                     
    private Date dataPedido;
    private Cliente cliente;
    private String cerimonial;
    private Date dataEvento;
    private TipoEvento tipoEvento;
    private String horaEvento;
    private String indicacao;
    private String localEvento;
    private String enderecoEvento;
    private String obs;
                    
                    
        }
        
        
        
        
        
        return null;
                
        
    }
    
}
