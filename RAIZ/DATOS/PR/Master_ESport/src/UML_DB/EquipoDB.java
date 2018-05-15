package UML_DB;

import UML.*;
import static UML_DB.DuennoDB.consultarDuennoCod;
import UML_DB.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase equipodb
 * Esta clase nos sirve para hacer un CRUD de equipo en la base de datos.
 */

public class EquipoDB {
    
    
    /**
     * Esta función nos permite insertar un equipo con su dueño en la base de datos
     */
    public void registrarEquipo(Equipo equipo, Duenno duenno) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO equipo (nombre, duenno_codduenno) VALUES ('"+equipo.getNombre()+"', '"+duenno.getCodusuario()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite consultar un equipo con su dueño en la base de datos y nos devuelve un objeto equipo
     */
    public static Equipo consultarEquipoCod(int codequipo) throws Exception{
        
        Equipo equipo = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM equipo where codequipo = ? ");
        consulta.setInt(1, codequipo);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            equipo = new Equipo();
            equipo.setCodequipo(Integer.parseInt(res.getString("codequipo")));
            equipo.setNombre(res.getString("nombre"));
            equipo.setDuenno(consultarDuennoCod(Integer.parseInt(res.getString("duenno_codduenno"))));
            
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return equipo;
    }
    
    /**
     * Esta función nos permite consultar un equipo y sus jugadores mediante el código de su dueño y nos devuelve un objeto equipo
     */
    public static Equipo consultarEquipoCodDuenno(int codDuenno) throws Exception{
        
        Equipo equipo = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM equipo where duenno_codduenno = ? ");
        consulta.setInt(1, codDuenno);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            equipo = new Equipo();
            equipo.setCodequipo(Integer.parseInt(res.getString("codequipo")));
            equipo.setNombre(res.getString("nombre"));
            equipo.setJugador(JugadorDB.listaDeJugadoresEquipo(String.valueOf(equipo.getCodequipo())));
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return equipo;
    }
    
    /**
     * Esta función nos permite consultar un equipo con su dueño y sus jugadores mediante su nombre y nos devuelve un objeto equipo
     */
    public static Equipo consultarEquipoNom(String nombre) throws Exception{
        
        Equipo equipo = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM equipo where nombre = ? ");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            equipo = new Equipo();
            equipo.setCodequipo(res.getInt("codequipo"));
            equipo.setNombre(res.getString("nombre"));
            equipo.setDuenno(consultarDuennoCod(res.getInt("duenno_codduenno")));
            equipo.setJugador(JugadorDB.listaDeJugadoresEquipo(String.valueOf(equipo.getCodequipo())));
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return equipo;
    }
    
    /**
     * esta función nos permite consultar todos los equipos que hay en la base de datos
     */
    public static ArrayList <Equipo> listaEquipo() throws Exception{
        
        ArrayList <Equipo> listaEquipo = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from equipo");
        
        while(res.next()){
            
          Equipo equipo = new Equipo();
          equipo.setCodequipo(res.getInt("codequipo"));
          equipo.setNombre(res.getString("nombre"));
          equipo.setDuenno(consultarDuennoCod(res.getInt("duenno_codduenno")));
          listaEquipo.add(equipo);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaEquipo;
    }
    
    /**
     * Esta función nos permite borrar un equipo mediante su codigo
     */
    public static void borrarEquipo(int codEquipo) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM equipo WHERE codequipo = '"+codEquipo+"'");
        
        conex.desconectar();
    }
}
