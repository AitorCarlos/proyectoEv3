package UML_DB;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase dbconnection
 * Esta clase nos sirve para hacer la conexión con la base de datos.
 */

import java.sql.*;

public class DbConnection {
    
    /**
     * Variables login, password, url para los datos de la base de datos
     */
    
    private String login = "eqdaw03";
    private String password = "eqdaw03";
    //private String login = "SCOTT";
    //private String password = "scott";
    private String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
    //private String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";
    //"jdbc:oracle:thin:@SrvOracle:1521:orcl"

    
    private Connection connection;
    
    public DbConnection() throws Exception{
        
         Class.forName("oracle.jdbc.OracleDriver");

         connection = DriverManager.getConnection(url,login,password);
 
         if (connection==null){
            throw new Exception("Error de conexión");
         }
   }
    
    public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}
