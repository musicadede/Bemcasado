/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.larimaia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rf3020
 */
public class ConexaoUtil {

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/clientesdb";
        String usuario = "postgres";
        String senha = "postgres";
        try {
            Connection connection = DriverManager.getConnection(url,usuario, senha);
            return  connection;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

}
