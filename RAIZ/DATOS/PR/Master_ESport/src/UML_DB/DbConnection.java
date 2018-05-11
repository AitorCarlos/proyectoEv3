/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML_DB;

/**
 *
 * @author 1GDAW03
 */

import java.sql.*;

public class DbConnection {
    
    //private String login = "eqdaw03";
    //private String password = "eqdaw03";
    private String login = "SCOTT";
    private String password = "scott";
    //private String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
    private String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";
    //"jdbc:oracle:thin:@SrvOracle:1521:orcl"

    
    private Connection connection;
    
    public DbConnection() throws Exception{
        
         Class.forName("oracle.jdbc.OracleDriver");

         connection = DriverManager.getConnection(url,login,password);
 
         if (connection==null){
            throw new Exception("Problemas con la conexión");
         }
   }
    
    public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}
