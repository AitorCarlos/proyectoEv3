/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author alex
 */
public class EquipoDB {
    
    
    //Registrar un equipo
    public void registrarEquipo(Equipo equipo, Duenno duenno) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO equipo (nombre, duenno_codduenno) VALUES ('"+equipo.getNombre()+"', '"+duenno.getCodusuario()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    //Consultar equipo y su dueño mediante su codigo
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
    
    //Consultar equipo por codigo de duenno
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
    
    //Consultar equipo mediante su nombre
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
    
    //Lista de equipos
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
    
    //Borrar un equipo
    public static void borrarEquipo(int codEquipo) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM equipo WHERE codequipo = '"+codEquipo+"'");
        
        conex.desconectar();
    }
}
