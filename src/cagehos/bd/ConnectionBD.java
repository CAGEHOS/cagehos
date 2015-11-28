package cagehos.bd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    static final String BDDriver = "org.postgresql.Driver";        
    static final String DEFAULT_BDNAME = "jdbc:postgresql://localhost:5432/bdcagehos";
    static final String DEFAULT_BDUSER = "postgres";
    static final String DEFAULT_BDPASS = "postgres";  
    
    private static String BDName;
    private String BDUser;
    private String BDPass;
    private Connection conn = null;
    private Statement stat = null;
    
    static {
        try {
            Class.forName(BDDriver);
        } catch (ClassNotFoundException e){
            javax.swing.JOptionPane.showMessageDialog(null,
                "Erro na Localizaçao do driver do banco de dados",
                "Problema com Driver",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            
            System.exit(1);
        }
    }
    
    public ConnectionBD(){
        this(DEFAULT_BDNAME, DEFAULT_BDUSER, DEFAULT_BDPASS);
    }
    
    public ConnectionBD(String pBDName, String pBDUser, String pBDPass){
        BDName = pBDName;
        BDUser = pBDUser;
        BDPass = pBDPass;
        
        try {
            conn = DriverManager.getConnection(pBDName, pBDUser, pBDPass);
        } catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null,
                "Erro ao tentar conexao com o banco de dados",
                "Erro de conexao",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public Connection getConexao(){
        return this.conn;
    }
    
    public Statement getDBCommand(){
        try {
            stat = conn.createStatement();
        } catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null,
                "Erro ao tentar conexao com o banco de dados",
                "Erro de conexao",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        } finally {
            if (stat == null){
                conn = null;
            }
            
            return stat;
        }
    }
    
    public void encerraConexao(){
        if (stat != null){
            try {
                stat.close();
                conn.close();
            } catch (SQLException evt){
                evt.printStackTrace(System.out);
            }
        }
    }   
}