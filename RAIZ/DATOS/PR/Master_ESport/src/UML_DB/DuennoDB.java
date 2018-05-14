package UML_DB;

import UML.*;
import UML_DB.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class DuennoDB {
    
    
    //Resgitrar un dueño
    public void registrarDuenno(Duenno duenno) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO usuarios (nickname, nombre, apellido, contrasenna, permiso) VALUES ('"+duenno.getNickname()+"', '"+duenno.getNombre()+"','"+duenno.getApellido()+"', '"+duenno.getContrasenna()+"', '"+duenno.getPermiso()+"')");
        sentencia.executeUpdate("INSERT INTO duenno (codduenno,usuarios_codusuario) VALUES ((select codusuario from usuarios where nickname = '"+duenno.getNickname()+"'),(select codusuario from usuarios where nickname = '"+duenno.getNickname()+"'))");
        sentencia.close();

        conex.desconectar();
    }
    
    
    //Buscar un dueño mediante su nombre
    public static Duenno consultarDuennoNickName(String nombre) throws Exception{
        
        Duenno duenno = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("select * from usuarios, duenno where usuarios.codusuario = Duenno.Usuarios_Codusuario and usuarios.nickname= ? ");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            duenno = new Duenno();
            duenno.setCodusuario(Integer.parseInt(res.getString("codduenno")));
            duenno.setNickname(res.getString("nickname"));
            duenno.setNombre(res.getString("nombre"));
            duenno.setApellido(res.getString("apellido"));
        }
        else
            throw new Exception ("Dueño no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return duenno;
    }
    
    
    //Buscar un dueño mediante su codigo
    public static Duenno consultarDuennoCod(int codduenno) throws Exception{
        
        Duenno duenno = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT codduenno FROM duenno where codduenno = ? ");
        consulta.setInt(1, codduenno);
        ResultSet res = consulta.executeQuery();

        while(res.next()){
            
            duenno = new Duenno();
            duenno.setCodusuario(Integer.parseInt(res.getString("codduenno")));
            
        }

        res.close();
        consulta.close();
        conex.desconectar();
 
        return duenno;
    }
    
    //Lista de los dueños que hay registrados
    public ArrayList <Duenno> listaDuenno() throws Exception{
        
        ArrayList <Duenno> listaDuenno = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from duenno");
        
        while(res.next()){
            
          Duenno duenno = new Duenno();
          duenno.setCodusuario(Integer.parseInt(res.getString("codduenno")));
          duenno.setNombre(res.getString("nombre"));
          duenno.setApellido(res.getString("apellido"));
          listaDuenno.add(duenno);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaDuenno;
    }
    
    //Borrar dueño mediante su codigo
    public void borrarDuenno(int codDuenno) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM duenno WHERE codduenno = '"+codDuenno+"'");
        
        conex.desconectar();
    }
    
    //Modificar el codigo_codequipo en el dueño, asignarle un equipo al dueño
    public void modificarDuennoCodEquipo(Equipo equipo, Duenno duenno) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("UPDATE duenno SET equipo_codequipo = '"+equipo.getCodequipo()+"' where codduenno = '"+duenno.getCodusuario()+"'");
        sentencia.close();

        conex.desconectar();
    }
}
