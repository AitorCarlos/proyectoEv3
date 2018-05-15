package UML_DB;

import UML.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase admindb
 * Esta clase nos sirve para hacer un CRUD de admin en la base de datos.
 */

public class AdminDB {
    
    /**
     * Esta función nos permite insertar un admin en la base de datos
     */
    public void registrarAdmin(Admin admin) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO usuarios (nickname, nombre, apellido, contrasenna, permiso) VALUES ('"+admin.getNickname()+"', '"+admin.getNombre()+"', '"+admin.getApellido()+"', '"+admin.getContrasenna()+"', '"+admin.getPermiso()+"')");
        sentencia.close();

        conex.desconectar();
    }

    /**
     * Esta función nos permite buscar un admin por su nombre en la base de datos y nos lo devuelve mediante un objeto admin
     */
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

    /**
     * Esta función nos permite buscar un admin por su codigo en la base de datos y nos lo devuelve mediante un objeto admin
     */
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
            throw new Exception ("Admin no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return admin;
    }
    
    
     /**
     * Esta función nos permite buscar todos los admins que hay en la base de datos y nos lo devuelve con un arraylist
     */
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
    
     /**
     * Esta función nos permite borrar un admin mediante su codigo
     */
    public void borrarAdmin(int codAdmin) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM usuarios WHERE codusuario = '"+codAdmin+"' and permiso = 'admin'");
        
        conex.desconectar();
    }
}
