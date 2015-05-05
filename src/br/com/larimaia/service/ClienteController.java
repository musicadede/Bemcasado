
package br.com.larimaia.service;

import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.model.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ClienteController {
    
    public List<String> listarNome (){
          ClienteDAO cli = new ClienteDAO();
          return cli.buscarNomeCliente();
        }
    }    

