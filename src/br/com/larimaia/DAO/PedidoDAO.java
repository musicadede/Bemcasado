package br.com.larimaia.DAO;

import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {

    // Criando Variavel conexao para realizar a conexão com banco de dados.
    Connection conexao;

    // Criando construtor da classe, para que seja iniciado uma conexão sempre que inicializado.
    public PedidoDAO() {
        conexao = ConexaoUtil.getConnection();
    }

    // Criando metodo para buscar o pedido pelo id
    public Pedido buscarPorId(int id) {
        // Criando String sql para receber um comando sql para ser executado no banco
        String sql = "SELECT * FROM Pedido WHERE id=?";

        try {
            // Criando preparadorPedidoSQL para inicia e finalizar sessão com banco
            PreparedStatement preparadorPedidoSQL;

            preparadorPedidoSQL = conexao.prepareStatement(sql);

            preparadorPedidoSQL.setInt(1, id);

            // Colocando resultado do SQL na variavel resultadoPedido
            ResultSet resultadoPedido = preparadorPedidoSQL.executeQuery();

            if (resultadoPedido.next()) {
                Pedido ped = new Pedido();

                    // Inserindo dados da consulta no objeto ped
                ped.setId(id);
                ped.setOrigemPedido(resultadoPedido.getString("origemPedido"));
                ped.setDataPedido(resultadoPedido.getDate("dataPedido"));
                ped.setCerimonial(resultadoPedido.getString("cerimonial"));
                ped.setCliente((Cliente) resultadoPedido.getObject("nome"));
                ped.setDataEvento(resultadoPedido.getDate("dataEvento"));
                ped.setTipoEvento((TipoEvento) resultadoPedido.getObject("tipoEvento"));
                ped.setHoraEvento(resultadoPedido.getString("horaEvento"));
                ped.setIndicacao(resultadoPedido.getString("indicacao"));
                ped.setLocalEvento(resultadoPedido.getString("localEvento"));
                ped.setEnderecoEvento(resultadoPedido.getString("enderecoString"));
                ped.setObs(resultadoPedido.getString("obs"));
                ped.setItens((List<ItemPedido>) resultadoPedido.getObject("itens"));
               
                preparadorPedidoSQL.close();
                return ped;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Pedido> buscarTodosPedidos() {
        // Criando String com comando sql para selecionar todos os pedidos
        String sql = "SELECT * FROM Pedido ORDER BY id";

        try {
            // Criando preparadorPedidoSQL para inicia e finalizar sessão com banco
            PreparedStatement preparadorPedidoSQL;
            preparadorPedidoSQL = conexao.prepareStatement(sql);

            // Colocando resultado do SQL na variavel resultadoPedido
            ResultSet resultadoPedido = preparadorPedidoSQL.executeQuery();
            List<Pedido> pedidos = new ArrayList<>();
            if (resultadoPedido.next()) {
                Pedido ped = new Pedido();

                // Inserindo dados da consulta no objeto ped
                ped.setId(resultadoPedido.getInt("idpedido"));
                ped.setOrigemPedido(resultadoPedido.getString("origemPedido"));
                ped.setDataPedido(resultadoPedido.getDate("dataPedido"));
                ped.setCerimonial(resultadoPedido.getString("cerimonial"));
                ped.setCliente((Cliente) resultadoPedido.getObject("nome"));
                ped.setDataEvento(resultadoPedido.getDate("dataEvento"));
                ped.setTipoEvento((TipoEvento) resultadoPedido.getObject("tipoEvento"));
                ped.setHoraEvento(resultadoPedido.getString("horaEvento"));
                ped.setIndicacao(resultadoPedido.getString("indicacao"));
                ped.setLocalEvento(resultadoPedido.getString("localEvento"));
                ped.setEnderecoEvento(resultadoPedido.getString("enderecoString"));
                ped.setObs(resultadoPedido.getString("obs"));
                ped.setItens((List<ItemPedido>) resultadoPedido.getObject("itens"));
                pedidos.add(ped);
                
            }
            preparadorPedidoSQL.close();
                return pedidos;
            } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    // Criacao do metodo salvar, que decide se o usuario ira cadastrar ou alterar pedido
    public void salvar(Pedido pedido) {
        if (pedido.getId() == null) {
            cadastrar(pedido);
        } else {
            alterar(pedido);
        }
    }
    
    //Metodo cadastrar pedido
    private void cadastrar(Pedido pedido) {
        // falta cadastrar a lista de itens de produto
        String sql;
        sql = "INSERT INTO Pedido(idpedido,origemPedido,dataPedido,idcliente,"
                + "cerimonial,dataEvento,idtipoEvento,horaEvento,"
                + "indicacao,localEvento,enderecoEvento,obs"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, "default");
            preparadorSQL.setString(2, pedido.getOrigemPedido());
            preparadorSQL.setDate(3, (Date) pedido.getDataPedido());
            preparadorSQL.setInt(4,pedido.getCliente().getId());
            preparadorSQL.setString(5, pedido.getCerimonial());
            preparadorSQL.setDate(6, (Date) pedido.getDataEvento());
            preparadorSQL.setInt(7, pedido.getTipoEvento().getId());
            preparadorSQL.setString(8, pedido.getHoraEvento());
            preparadorSQL.setString(9, pedido.getIndicacao());
            preparadorSQL.setString(10, pedido.getLocalEvento());
            preparadorSQL.setString(11, pedido.getEnderecoEvento());
            preparadorSQL.setString(12, pedido.getObs());
            
            preparadorSQL.execute();
            preparadorSQL.close();

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //metodo alterar pedido
    private void alterar(Pedido pedido) {
        // falta alterar a lista de itens de produto
        String sql = "UPDATE Pedido SET origempedido=?,datapedido=?,idcliente=?,"
                + "cerimonial=?,dataEvento=?,idtipoEvento=?,horaEvento=?,indicacao=?,"
                + "localEvento=?,enderecoEvento=?,obs=? WHERE id=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);

            preparadorSQL.setString(1, pedido.getOrigemPedido());
            preparadorSQL.setDate(2, (Date) pedido.getDataPedido());
            preparadorSQL.setInt(3,pedido.getCliente().getId());
            preparadorSQL.setString(4, pedido.getCerimonial());
            preparadorSQL.setDate(5, (Date) pedido.getDataEvento());
            preparadorSQL.setInt(6, pedido.getTipoEvento().getId());
            preparadorSQL.setString(7, pedido.getHoraEvento());
            preparadorSQL.setString(8, pedido.getIndicacao());
            preparadorSQL.setString(9, pedido.getLocalEvento());
            preparadorSQL.setString(10, pedido.getEnderecoEvento());
            preparadorSQL.setString(11, pedido.getObs());
            preparadorSQL.setInt(12, pedido.getId());
            
            preparadorSQL.execute();
            preparadorSQL.close();

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo excluir um pedido atraves de seu id
    public void excluir(int id) {

        String sql = "DELETE FROM Pedido WHERE id=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);

            preparadorSQL.setInt(1, id);
            preparadorSQL.execute();
            preparadorSQL.close();

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
