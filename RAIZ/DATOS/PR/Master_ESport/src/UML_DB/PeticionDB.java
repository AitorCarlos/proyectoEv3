/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML_DB;

import UML.Duenno;
import UML.Equipo;
import UML.Jugador;
import static UML_DB.DuennoDB.consultarDuennoCod;
import static UML_DB.DuennoDB.consultarDuennoNickName;
import static UML_DB.EquipoDB.consultarEquipoCod;
import static UML_DB.EquipoDB.consultarEquipoNom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase peticiondb
 * Esta clase nos sirve para hacer un CRUD de peticion en la base de datos.
 */

public class PeticionDB {

    /**
     * Variables globale para saber que tipo de peticion se ha realizado
     */
    public static String tipoDuenno;
    public static String tipoEquipo;
    public static String tipoJugador;
    
    /**
     * Esta función nos permite insertar una peticion de dueño en la base de datos
     */
    public void peticionDuenno(Duenno duenno, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nickname, nombre, apellido, contrasenna, permiso, tipo)"
                + "VALUES ('"+duenno.getNickname()+"', '"+duenno.getNombre()+"', '"+duenno.getApellido()+"', '"+duenno.getContrasenna()+"', '"+duenno.getPermiso()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite insertar una peticion de jugador con equipo en la base de datos
     */
    public void peticionJugadorEquipo(Jugador jugador, Equipo equipo, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, apellido, nickname, sueldo, equipo, tipo)"
                + "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', "+jugador.getSueldo()+", '"+equipo.getNombre()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite insertar una peticion de jugador sin equipo en la base de datos
     */
    public void peticionJugadorSin(Jugador jugador, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, apellido, nickname, sueldo, tipo)"
                + "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', "+jugador.getSueldo()+", '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite insertar una peticion de equipo con su dueño en la base de datos
     */
    public void peticionEquipo(Equipo equipo, Duenno duenno, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, nickname, tipo)"
                + "VALUES ('"+equipo.getNombre()+"', '"+duenno.getNickname()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite consultar todas las peticiones de dueño de la base de datos
     */
    public ArrayList <Duenno> listaPetiDuenno() throws Exception{
        
        ArrayList <Duenno> listaDuenno = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from peticion where tipo = 'duenno'");
        
        while(res.next()){
            
          Duenno duenno = new Duenno();
          duenno.setNickname(res.getString("nickname"));
          duenno.setNombre(res.getString("nombre"));
          duenno.setApellido(res.getString("apellido"));
          duenno.setContrasenna(res.getString("contrasenna"));
          duenno.setPermiso(res.getString("permiso"));
          tipoDuenno = res.getString("tipo");
          listaDuenno.add(duenno);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaDuenno;
    }
    
    /**
     * Esta función nos permite consultar todas las peticiones de jugador de la base de datos
     */
    public ArrayList <Jugador> listaPetiJugador() throws Exception{
        
        ArrayList <Jugador> listaJugador = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from peticion where tipo = 'jugador'");
        
        while(res.next()){
            
          Jugador jugador = new Jugador();
          jugador.setNombre(res.getString("nombre"));
          jugador.setApellido(res.getString("apellido"));
          jugador.setNickname(res.getString("nickname"));
          if(res.getString("sueldo")==null){
          
              jugador.setSueldo(0d);
          }
          else{
              
              jugador.setSueldo(Double.parseDouble(res.getString("sueldo")));
          }
          jugador.setEquipo(consultarEquipoNom(res.getString("equipo")));
          tipoJugador = res.getString("tipo");
          listaJugador.add(jugador);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaJugador;
    }
    
    /**
     * Esta función nos permite consultar todas las peticiones de equipo de la base de datos
     */
    public ArrayList <Equipo> listaPetiEquipo() throws Exception{
        
        ArrayList <Equipo> listaEquipo = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from peticion where tipo = 'equipo'");
        
        while(res.next()){
            
          Equipo equipo = new Equipo();
          equipo.setNombre(res.getString("nombre"));
          equipo.setDuenno(consultarDuennoNickName(res.getString("nickname")));
          tipoEquipo = res.getString("tipo");
          listaEquipo.add(equipo);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaEquipo;
    }
    
    /**
     * Esta función nos permite borrar las peticiones mediante su nickname
     */
    public void borrarPeticionDJ(String nickname) throws Exception{
    
        DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM peticion WHERE nickname = '"+nickname+"'");
        
        conex.desconectar();
    }
    
    /**
     * Esta función nos permite borrar las peticiones mediante su nombre
     */
    public void borrarPeticionE(String nombre) throws Exception{
    
        DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM peticion WHERE nombre = '"+nombre+"'");
        
        conex.desconectar();
    }

}
