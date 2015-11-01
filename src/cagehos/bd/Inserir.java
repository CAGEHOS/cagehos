/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cagehos.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dias
 */
public class Inserir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionBD conector = new ConnectionBD();
        Connection conexao = conector.getConexao();

        try {
            PreparedStatement cmdParam = conexao.prepareStatement("INSERT INTO empregado (nome) VALUES (?)");

            String nome = "ZimbabueTESTE";

            cmdParam.setString(1, nome);
            //cmdParam.setString(2, codigo);

            int linhas = cmdParam.executeUpdate();

            System.out.println("Linhas afetadas: " + linhas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
