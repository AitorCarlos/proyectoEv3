package UML_DB;

import UML.Equipo;
import UML.Jugador;
import static UML_DB.EquipoDB.consultarEquipoCod;
import UML_DB.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase jugadordb
 * Esta clase nos sirve para hacer un CRUD de jugador en la base de datos.
 */

public  class JugadorDB {
    
    /**
     * Esta función nos permite insertar un jugador sin sueldo en la base de datos
     */
    public static void registrarJugador(Jugador jugador) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO jugador (nombre, apellido, nickname) VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite insertar un jugador con sueldo en la base de datos
     */
    public static void registrarJugadorS(Jugador jugador) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO jugador (nombre, apellido, sueldo, nickname) VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', "+jugador.getSueldo()+", '"+jugador.getNickname()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite insertar un jugador con su equipo en la base de datos
     */
    public static void registrarJugadorConEquipo(Jugador jugador) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO jugador (nombre, apellido, nickname, sueldo, equipo_codequipo) VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', "+jugador.getSueldo()+", "+jugador.getEquipo().getCodequipo()+")");
        sentencia.close();

        conex.desconectar();
    }
    
    
    /**
     * Esta función nos permite buscar un jugador con su equipo mediante su código en la base de datos y nos devuelve un objeto jugador
     */
    public Jugador consultarJugadorCod(int codjugador) throws Exception{
        
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where codjugador = ? ");
        consulta.setInt(1, codjugador);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
            jugador.setEquipo(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipo"))));
            
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugador;
    }
    
    /**
     * Esta función nos permite buscar un jugador con su equipo mediante su nickname en la base de datos y nos devuelve un objeto jugador
     */
    public static Jugador consultarJugadorNick(String nickname) throws Exception{
        
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where nickname = ? ");
        consulta.setString(1, nickname);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setEquipo(EquipoDB.consultarEquipoCod(res.getInt("equipo_codequipo")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
            
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugador;
    }
    
    /**
     * Esta función nos permite buscar un jugador sin equipo mediante su código en la base de datos y nos devuelve un objeto jugador
     */
    public static Jugador consultarJugadorNickSinEquipo(String nickname) throws Exception{
        
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where nickname = ? ");
        consulta.setString(1, nickname);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugador;
    }
    
    /**
     * Esta función nos permite buscar todos los jugadores que hay la base de datos y nos devuelve un arraylist
     */
    public ArrayList <Jugador> listaJugador() throws Exception{
        
        ArrayList <Jugador> listaJugador = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from jugador");
        
        while(res.next()){
            
            Jugador jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
            jugador.setEquipo(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipo"))));
            listaJugador.add(jugador);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaJugador;
    }
    
    /**
     * Esta función nos permite borrar un jugador mediante su código
     */
    public void borrarJugador(int codJugador) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM jugador WHERE codjugador = '"+codJugador+"'");
        
        conex.desconectar();
    }
    
    /**
     * Esta función nos permite modificar un jugador en la base de datos
     */
    public static void modificarJugador(Jugador jugador) throws Exception{

       DbConnection conex = new DbConnection();

        PreparedStatement sentencia = conex.getConnection().prepareStatement(
                "UPDATE jugador SET nombre = ? , apellido = ? , nickname = ? , sueldo = ? where codJugador = ? "
        );
        sentencia.setString(1, jugador.getNombre());
        sentencia.setString(2, jugador.getApellido());
        sentencia.setString(3, jugador.getNickname());
        sentencia.setDouble(4, jugador.getSueldo());
        sentencia.setInt(5, jugador.getCodjugador());
        
        sentencia.executeUpdate();
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite modificar el codigo_codequipo en el jugador o asignarle un jugador al equipo
     */
    public static void modificarJugadorCodEquipo(Equipo equipo, Jugador jugador) throws Exception{

        
       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        if (equipo == null) 
            sentencia.executeUpdate("UPDATE jugador SET equipo_codequipo = null, sueldo = null where codjugador = '"+jugador.getCodjugador()+"'");
        else
            sentencia.executeUpdate("UPDATE jugador SET equipo_codequipo = '"+equipo.getCodequipo()+"', sueldo = " + jugador.getSueldo() + " where codjugador = '"+jugador.getCodjugador()+"'");
        sentencia.close();

        conex.desconectar();
    }
    
    
    /**
     * Esta función nos permite consultar un jugador sin equipo en la base de datos y nos devuelve un objeto jugador
     */
    public Jugador conJuga(String nombre) throws Exception{
        
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where nombre = ? ");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
            
        }
        else
            throw new Exception ("Jugador no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugador;
    }
    
    /**
     * Esta función nos permite buscar todos los jugadores que hay en la base de datos que no tengan equipo y nos devuelve un arraylist
     */
        public static ArrayList <Jugador> listaDeJugadoresSinEquipo() throws SQLException, Exception{
        ArrayList jugadores = new <Jugador> ArrayList(); 
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where equipo_codequipo is null");
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugadores.add(jugador);
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugadores;
    }
    
     /**
     * Esta función nos permite buscar todos los jugadores con su equipo que hay en la base de datos y nos devuelve un arraylist
     */
    public static ArrayList <Jugador> listaDeJugadoresEquipo(String codEquipo) throws SQLException, Exception{
        ArrayList jugadores = new <Jugador> ArrayList(); 
        Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jugador where equipo_codequipo = ? ");
        consulta.setString(1, codEquipo);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            jugador = new Jugador();
            jugador.setCodjugador(Integer.parseInt(res.getString("codjugador")));
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
            jugadores.add(jugador);
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugadores;
    }
    
    public static void quitarJugadorEquipo(Equipo equipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        
        sentencia.executeUpdate("update jugador set EQUIPO_CODEQUIPO = null, sueldo = 0 where EQUIPO_CODEQUIPO = '"+equipo.getCodequipo()+"'");
        
        conex.desconectar();
    }
}
