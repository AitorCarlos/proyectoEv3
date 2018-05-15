package UML_DB;

import UML.Miembro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase miembrodb
 * Esta clase nos sirve para hacer un CRUD de miembro en la base de datos.
 */

public class MiembroDB {
    
    /**
     * Esta función nos permite insertar un miembro en la base de datos
     */
    public static void registrarUsuario(Miembro miembro) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO usuarios (nickname, nombre, apellido, contrasenna, permiso) VALUES ('"+miembro.getNickname()+"', '"+miembro.getNombre()+"', '"+miembro.getApellido()+"', '"+miembro.getContrasenna()+"', '"+miembro.getPermiso()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    
    /**
     * Esta función nos permite buscar un miembro mediante su nombre en la base de datos y nos devuelve un objeto miembro
     */
    public static Miembro consultarMiembroNom(String nombre) throws Exception{
        
        Miembro miembro = null;
        DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where nickname = ?");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            miembro = new Miembro();
            miembro.setCodusuario(res.getInt("codusuario"));
            miembro.setNombre(res.getString("nombre"));
            miembro.setApellido(res.getString("apellido"));
            miembro.setNickname(res.getString("nickname"));
            miembro.setContrasenna(res.getString("contrasenna"));
            miembro.setPermiso(res.getString("permiso"));
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return miembro;
    }
    
    
    /**
     * Esta función nos permite buscar un miembro mediante su código en la base de datos y nos devuelve un objeto miembro
     */
    public static Miembro consultarMiembroCod(int codMiembro) throws Exception{
        
        Miembro miembro = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where codusuario = ? and permiso = 'miembro'");
        consulta.setInt(1, codMiembro);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            miembro = new Miembro();
            miembro.setCodusuario(Integer.parseInt(res.getString("codduenno")));
            miembro.setNickname(res.getString("nickname"));
            miembro.setContrasenna(res.getString("contrasenna"));
            miembro.setPermiso(res.getString("permiso"));
            
        }
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return miembro;
    }
    
    
    /**
     * Esta función nos permite buscar todos los miembros que hay en la base de datos y nos devuelve un arraylist
     */
    public static ArrayList <Miembro> listaMiembro() throws Exception{
        
        ArrayList <Miembro> listaMiembro = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from usuarios where permiso = 'miembro'");
        
        while(res.next()){
            
          Miembro miembro = new Miembro();
          miembro.setCodusuario(Integer.parseInt(res.getString("codduenno")));
          miembro.setNickname(res.getString("nickname"));
          miembro.setContrasenna(res.getString("contrasenna"));
          miembro.setPermiso(res.getString("permiso"));
          listaMiembro.add(miembro);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaMiembro;
    }
    
    /**
     * Esta función nos permite borrar un miembro de la base de datos madiante su código
     */
    public static void borrarMiembro(int codMiembro) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM usuarios WHERE codusuario = '"+codMiembro+"' and permiso = 'miembro'");
        
        conex.desconectar();
    }
}
