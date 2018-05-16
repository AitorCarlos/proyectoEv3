package UML_DB;

import java.sql.Statement;
import UML.Jornada;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import oracle.sql.DATE;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase jornadadb
 * Esta clase nos sirve para hacer un CRUD de jornada en la base de datos.
 */

public class JornadaDB {
    
    /**
     * Esta función nos permite insertar una jornada en la base de datos
     */
    public void registrarJornada(UML.Jornada jornada) throws Exception{
        
       DbConnection conex = new DbConnection();
  
           Statement sentencia = conex.getConnection().createStatement();
           sentencia.executeUpdate("INSERT INTO jornada (fechajornadai, fechajornadaf) VALUES (TO_DATE('"+jornada.getFechaInicio()+"', 'yy-MM-dd'), TO_DATE('"+jornada.getFechaFin()+"', 'yy-MM-dd'))");
           sentencia.close();

           conex.desconectar();
    }

    /**
     * Esta función nos permite insertar una jornada y obtener la ultima jornada que se ha insertado
     */
    public Jornada inVerJornada(Jornada jornada)throws Exception{
    
        DbConnection conex = new  DbConnection();
        
        CallableStatement stmt = conex.getConnection().prepareCall("BEGIN in_ver_jornada(?, TO_DATE('"+jornada.getFechaInicio()+"', 'yy-MM-dd'), TO_DATE('"+jornada.getFechaFin()+"', 'yy-MM-dd')); END;");
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.execute();
        int x = stmt.getInt(1);
        
        jornada.setCodJornada(x);
        
        conex.desconectar();
        
        return jornada;
    }
    
    /**
     * Esta función nos permite consultar una jornada mediante su código
     */
    public static Jornada consultarJornada(int codJornada) throws Exception{
        
        Jornada jornada = null;
        DbConnection conex= new  DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jornada where codjornada = ? ");
        consulta.setInt(1, codJornada);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jornada = new Jornada();
            jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
            jornada.setFechaInicio(res.getDate("fechajornadai"));
            jornada.setFechaFin(res.getDate("fechajornadaf"));
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jornada;
    }
    
    /**
     * Esta función nos permite consultar todas las jornadas que tengamos en la base de datos ordenadas por su código
     */
    public static ArrayList <Jornada> listaJornada() throws Exception{
        
        ArrayList <Jornada> listaJornada = new ArrayList();

        DbConnection conex= new  DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from jornada order by codjornada asc");
        
        while(res.next()){
            
          Jornada jornada = new Jornada();
          jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
          jornada.setFechaInicio(res.getDate("fechajornadai"));
          jornada.setFechaFin(res.getDate("fechajornadaf"));
          jornada.setPartido(PartidoDB.listaPartidoPorJornada(jornada.getCodJornada()));
          listaJornada.add(jornada);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaJornada;
    }

    /**
     * Esta función nos permite borrar todas las jornadas que tengamos
     */
    public static void borrarTodasJornadas() throws Exception{
    
        DbConnection conex= new  DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM jornada");
        
        conex.desconectar();
    }
    
    /**
     * Esta función nos permite borrar una jornada por su código
     */
    public void borrarJornada(int codJornada) throws Exception{
    
        DbConnection conex= new  DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM jornada WHERE codjornada = '"+codJornada+"'");
        
        conex.desconectar();
    }
    
    /**
     * Esta función nos permite ver una jornada por su código
     */
    public static Jornada verJornada(int codJornada) throws Exception{
        
        Jornada jornada = null;
        DbConnection conex= new  DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jornada where codjornada = ? ");
        consulta.setInt(1, codJornada);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            jornada = new Jornada();
            jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
            jornada.setFechaInicio(res.getDate("fechajornadai"));
            jornada.setFechaFin(res.getDate("fechajornadaf"));
            jornada.setPartido(PartidoDB.listaPartidoPorJornada(codJornada));
        }
        else
            throw new Exception ("Jornada no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jornada;
    }
}
