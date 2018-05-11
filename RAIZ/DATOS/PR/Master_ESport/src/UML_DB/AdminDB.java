/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML_DB;

import UML.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 1GDAW03
 */
public class AdminDB {
    
    //Resgitrar un admin
    public void registrarAdmin(Admin admin) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO usuarios (nickname, nombre, apellido, contrasenna, permiso) VALUES ('"+admin.getNickname()+"', '"+admin.getNombre()+"', '"+admin.getApellido()+"', '"+admin.getContrasenna()+"', '"+admin.getPermiso()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    
    //Buscar un admin mediante su nombre
    public Admin consultarAdminNom(String nombre) throws Exception{
        
        Admin admin = null;
        DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where nombre = ? and permiso = 'admin'");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            admin = new Admin();
            admin.setCodusuario(Integer.parseInt(res.getString("codduenno")));
            admin.setNickname(res.getString("nickname"));
            admin.setNombre(res.getString("nombre"));
            admin.setApellido(res.getString("apellido"));
            admin.setContrasenna(res.getString("contrasenna"));
            admin.setPermiso(res.getString("permiso"));
            
        }
        else
            throw new Exception ("Admin no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return admin;
    }
    
    
    //Buscar un admin mediante su codigo
    public static Admin consultarAdminCod(int codadmin) throws Exception{
        
        Admin admin = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where codusuario = ? and permiso = 'admin'");
        consulta.setInt(1, codadmin);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            admin = new Admin();
            admin.setCodusuario(Integer.parseInt(res.getString("codduenno")));
            admin.setNickname(res.getString("nickname"));
            admin.setNombre(res.getString("nombre"));
            admin.setApellido(res.getString("apellido"));
            admin.setContrasenna(res.getString("contrasenna"));
            admin.setPermiso(res.getString("permiso"));
            
        }
        else
            throw new Exception ("Dueño no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return admin;
    }
    
    
    //Lista de los admin que hay registrados
    public ArrayList <Admin> listaAdmin() throws Exception{
        
        ArrayList <Admin> listaAdmin = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from usuarios where permiso = 'admin'");
        
        while(res.next()){
            
          Admin admin = new Admin();
          admin.setCodusuario(Integer.parseInt(res.getString("codduenno")));
          admin.setNickname(res.getString("nickname"));
          admin.setNombre(res.getString("nombre"));
          admin.setApellido(res.getString("apellido"));
          admin.setContrasenna(res.getString("contrasenna"));
          admin.setPermiso(res.getString("permiso"));
          listaAdmin.add(admin);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaAdmin;
    }
    
    //Borrar admin mediante su codigo
    public void borrarAdmin(int codAdmin) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM usuarios WHERE codusuario = '"+codAdmin+"' and permiso = 'admin'");
        
        conex.desconectar();
    }
}
