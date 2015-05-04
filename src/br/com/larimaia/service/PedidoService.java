package br.com.larimaia.service;

import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.exception.ServiceException;
import java.util.List;

public class PedidoService {
    private PedidoDAO pedidoDAO;

    public PedidoService() {
        pedidoDAO = new PedidoDAO();
    }

    public void salvar(Pedido pedido) throws ServiceException {

        if (pedido.getOrigemPedido().isEmpty()) {
            throw new ServiceException("Campo Local do Contrato é obrigatório!");
        }

        if (pedido.getDataPedido() == null) {
            throw new ServiceException("Campo Data do Pedido é obrigatório!");
        }
        
        if (pedido.getCliente().getNome().isEmpty()) {
            throw new ServiceException("Campo Cliente é obrigatório!");
        }

        if (pedido.getCerimonial().isEmpty()) {
            throw new ServiceException("Campo Cerimonial é obrigatório!");
        }
        
        if (pedido.getDataEvento() == null) {
            throw new ServiceException("Campo Data do Evento é obrigatório!");
        }

        if (pedido.getTipoEvento().getDescricao().isEmpty()) {
            throw new ServiceException("Campo Tipo é obrigatório!");
        }
        
        if (pedido.getHoraEvento().isEmpty()) {
            throw new ServiceException("Campo Hora é obrigatório!");
        }
        
        if (pedido.getLocalEvento().isEmpty()) {
            throw new ServiceException("Campo Local do Evento é obrigatório!");
        }
        
        if (pedido.getEnderecoEvento().isEmpty()) {
            throw new ServiceException("Campo Endereço é obrigatório!");
        }
        
        if (pedido.getTipoEvento().getDescricao().isEmpty()) {
            throw new ServiceException("Campo Tipo é obrigatório!");
        }

       //pedidoDAO.salvar(pedido);

    }

   // public void excluir(Integer id) {
        //pedidoDAO.excluir(id);
    //}

    //public Pedido buscarPorId(Integer id) {
       // return pedidoDAO.buscarPorId();
    //}

    //public List<Pedido> buscarTodos() {
      //      return pedidoDAO.buscarTodos();
    //}
}
