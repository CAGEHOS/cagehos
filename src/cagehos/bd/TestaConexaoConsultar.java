/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cagehos.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sun.invoke.empty.Empty;

/**
 *
 * @author Dias
 */
public class TestaConexaoConsultar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionBD conector = new ConnectionBD();
        Connection conexao = conector.getConexao();
        Statement comando = conector.getDBCommand();
        
        try {
            ResultSet resultado = comando.executeQuery("SELECT * FROM empregado");
            while(resultado.next()){ 
                String nome = resultado.getString("nome");
                System.out.println(nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
