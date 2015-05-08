
package br.com.larimaia.DAO;

import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.util.ConexaoUtil;
import java.sql.Connection;
import java.util.List;


public class ItemPedidoDAO {
    
    Connection conexao;
    
    public ItemPedidoDAO(){
        conexao= ConexaoUtil.getConnection();
    }
    
    public List<ItemPedido> listarItens(){
        String sql = "SELECT * FROM ";
        return null;
    }
    
}
