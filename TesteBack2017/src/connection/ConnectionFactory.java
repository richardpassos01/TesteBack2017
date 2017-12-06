package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionFactory {
    
    
     //Atributos para armazenar dados de conexão 
   private static final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
   private static final String URL  = "jdbc:oracle:thin:@localhost:1521:XE";  
   private static final String USERNAME = "system";  
   private static final String PASSWORD = "123456";  
   
     //metodo de validação de conexão
   public static Connection getConnection(){   
       try { 
           Class.forName(DRIVERNAME);          
           return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        } catch (ClassNotFoundException | SQLException ex) {      
            throw new RuntimeException("Erro ao fazer conexão:",ex);           
       } 
   }
   
    //Encerrar conexão   
   public static void closeConnection(Connection con){
           try {
               if(con!=null){
               con.close();
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
      
    //Sobrecarga do metodo close com PrepararedStament.
   public static void closeConnection(Connection con, PreparedStatement stmt){           
            closeConnection(con);
       
            try {
               if(stmt!=null){
               stmt.close();
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
   
    //Sobrecarga do metodo close com Results.
   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){           
            closeConnection(con,stmt);
       
            try {
               if(rs!=null){
               rs.close();
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
    }   
}
              
 
     




