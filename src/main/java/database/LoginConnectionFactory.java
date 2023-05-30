
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoginConnectionFactory {
    
    private static String host = "127.0.0.1";
    private static String porta = "3306";
    private static String db = "db_getong";
    private static String usuario = "WEBSTER";
    private static String senha = "web159";
    
     public static Connection obtemConexao() throws Exception{
       String url = String.format("jdbc:mysql://%s:%s/%s", host, porta, db);
       return DriverManager.getConnection(url, usuario, senha);
    }
}
