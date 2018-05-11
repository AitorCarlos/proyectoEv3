/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML_DB;

import UML.Duenno;
import UML.Equipo;
import UML.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 1GDAW03
 */
public class PeticionDB {
    
    public static String tipo;
    
    public void peticionDuenno(Duenno duenno, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nickname, nombre, apellido, contrasenna, permiso, tipo)"
                + "VALUES ('"+duenno.getNickname()+"', '"+duenno.getNombre()+"', '"+duenno.getApellido()+"', '"+duenno.getContrasenna()+"', '"+duenno.getPermiso()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public void peticionJugador(Jugador jugador, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, apellido, nickname, sueldo, tipo)"
                + "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido()+"', '"+jugador.getNickname()+"', '"+jugador.getSueldo()+"', '"+tipo+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    public void peticionEquipo(Equipo equipo, String tipo) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO peticion (nombre, tipo)"
                + "VALUES ('"+equipo.getNombre()+"', '"+tipo+"')");
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
            tipo = res.getString("tipo");
            
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
            tipo = res.getString("tipo");
            
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
            tipo = res.getString("tipo");
            
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
          tipo = res.getString("tipo");
          listaDuenno.add(duenno);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaDuenno;
    }
    
    public ArrayList <Duenno> listaPetiJugador() throws Exception{
        
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
          tipo = res.getString("tipo");
          listaDuenno.add(duenno);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaDuenno;
    }
    
    public void borrarPeticionDJ(String nickname) throws Exception{
    
        DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM peticion WHERE nickname = '"+nickname+"'");
        
        conex.desconectar();
    }

}
