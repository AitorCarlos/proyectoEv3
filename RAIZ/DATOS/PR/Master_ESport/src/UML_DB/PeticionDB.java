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
 * @author 1GDAW03
 */
public class PeticionDB {

    public static String tipoDuenno;
    public static String tipoEquipo;
    public static String tipoJugador;
    
    public void peticionDuenno(Duenno duenno, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nickname, nombre, apellido, contrasenna, permiso, tipo)"
                + "VALUES ('"+duenno.getNickname()+"', '"+duenno.getNombre()+"', '"+duenno.getApellido()+"', '"+duenno.getContrasenna()+"', '"+duenno.getPermiso()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public void peticionJugadorEquipo(Jugador jugador, Equipo equipo, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, apellido, nickname, sueldo, equipo, tipo)"
                + "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', "+jugador.getSueldo()+", '"+equipo.getNombre()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public void peticionJugadorSin(Jugador jugador, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, apellido, nickname, sueldo, tipo)"
                + "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', "+jugador.getSueldo()+", '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public void peticionEquipo(Equipo equipo, Duenno duenno, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, nickname, tipo)"
                + "VALUES ('"+equipo.getNombre()+"', '"+duenno.getNickname()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public Duenno consultarDuenno() throws Exception{
        
       Duenno duenno = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM peticion");
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            duenno = new Duenno();
            duenno.setNickname(res.getString("nickname"));
            duenno.setNombre(res.getString("nombre"));
            duenno.setApellido(res.getString("apellido"));
            duenno.setContrasenna(res.getString("contrasenna"));
            duenno.setPermiso(res.getString("permiso"));
            tipoDuenno = res.getString("tipo");
            
        }
        else
            throw new Exception ("Dueño no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return duenno;
    }
    
    public Jugador consultarJugador() throws Exception{
        
       Jugador jugador = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM peticion");
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            jugador = new Jugador();
            jugador.setNombre(res.getString("nombre"));
            jugador.setApellido(res.getString("apellido"));
            jugador.setNickname(res.getString("nickname"));
            jugador.setSueldo(Double.valueOf(res.getString("sueldo")));
            tipoJugador = res.getString("tipo");
            
        }
        else
            throw new Exception ("Jugador no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jugador;
    }
    
    public Equipo consultarEquipo() throws Exception{
        
       Equipo equipo = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM peticion");
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            equipo = new Equipo();
            equipo.setNombre(res.getString("nombre"));
            equipo.setDuenno(consultarDuennoCod(Integer.parseInt(res.getString("duenno_codduenno"))));
            tipoEquipo = res.getString("tipo");
            
        }
        else
            throw new Exception ("Equipo no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return equipo;
    }
    
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
    
    public void borrarPeticionDJ(String nickname) throws Exception{
    
        DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM peticion WHERE nickname = '"+nickname+"'");
        
        conex.desconectar();
    }
    
    public void borrarPeticionE(String nombre) throws Exception{
    
        DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM peticion WHERE nombre = '"+nombre+"'");
        
        conex.desconectar();
    }

}
