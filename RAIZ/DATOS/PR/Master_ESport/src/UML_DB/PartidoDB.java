package UML_DB;

import UML.Equipo;
import UML.*;
import UML_DB.DbConnection;
import static UML_DB.EquipoDB.consultarEquipoCod;
import static UML_DB.JornadaDB.verJornada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase partidodb
 * Esta clase nos sirve para hacer un CRUD de partido en la base de datos.
 */

public class PartidoDB {
    
    /**
     * Esta función nos permite insertar un partido con su jornada y sus equipos en la base de datos
     */
    public void registrarPartido(Partido partido, Jornada jornada, Equipo visitante, Equipo local) throws Exception{

       DbConnection conex = new DbConnection();

        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("INSERT INTO partido (fecha, hora, jugado, jornada_codjornada, equipo_codequipovisitante, equipo_codequipolocal)"
                + "VALUES (TO_DATE('"+partido.getFecha()+"', 'yy/MM/dd'), '"+partido.getHora()+"', '"+partido.isJugado()+"', '"+jornada.getCodJornada()+"', '"+visitante.getCodequipo()+"', '"+local.getCodequipo()+"')");
        sentencia.close();

        conex.desconectar();
    }
    
    /**
     * Esta función nos permite buscar el código de partido en la base de datos mediante su código y nos devuelve un objeto partido
     */
    public static  Partido consultarCodPartido(int codpartido) throws Exception{
        
        Partido partido = null;
       DbConnection conex = new DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM partido where codpartido = ? ");
        consulta.setInt(1, codpartido);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            partido = new Partido();
            partido.setCodpartido(Integer.parseInt(res.getString("codpartido")));
            
        }
        else
            throw new Exception ("Partido no encontrado");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return partido;
    }
    
    /**
     * esta función nos permite buscar un partido con todos sus datos en la base de datos mediante su código y nos devuelve un objeto partido
     */
    public static   Partido consultarPartidoCod(int codpartido) throws Exception{
        
        Partido partido = null;
        DbConnection conex = new DbConnection();
        
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM partido where codpartido = ? ");
        consulta.setInt(1, codpartido);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            partido = new Partido();
            partido.setCodpartido(Integer.parseInt(res.getString("codpartido")));
            partido.setFecha(res.getDate("fecha"));
            partido.setHora(res.getString("hora"));
            partido.setJugado(Boolean.parseBoolean(res.getString("jugado")));
            partido.setJornada(verJornada(Integer.parseInt(res.getString("jornada_codjornada"))));
            partido.setVisitante(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipovisitante"))));
            partido.setLocal(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipolocal"))));
            partido.setResultadoEL(Integer.parseInt(res.getString("resultadoe1")));
            partido.setResultadoEV(Integer.parseInt(res.getString("resultadoe2")));
            
        }
        else
            throw new Exception ("Partido no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return partido;
    }
    
    /**
     * Esta función nos permite buscar todos los partidos en la base de datos y nos devuelve un arraylist
     */
    public static ArrayList <Partido> listaPartido() throws Exception{
        
        ArrayList <Partido> listaPartido = new ArrayList();

       DbConnection conex = new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from partido");
        
        while(res.next()){
            
          Partido partido = new Partido();
          partido.setCodpartido(Integer.parseInt(res.getString("codpartido")));
          partido.setFecha(res.getDate("fecha"));
          partido.setHora(res.getString("hora"));
          partido.setJugado(Boolean.valueOf(res.getString("jugado")));
          partido.setVisitante(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipovisitante"))));
          partido.setLocal(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipolocal"))));
          partido.setResultadoEL(Integer.parseInt(res.getString("resultadoE1")));
          partido.setResultadoEV(Integer.parseInt(res.getString("resultadoE2")));
          listaPartido.add(partido);
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaPartido;
    }
    
    /**
     * Esta función nos permite buscar todos los partidos por jornada en la base de datos y nos devuelve un arraylist
     */
    public static ArrayList <Partido> listaPartidoPorJornada(int codJornada) throws Exception{
        
        ArrayList <Partido> listaPartido = new ArrayList();

       DbConnection conex = new DbConnection();
       
        PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from partido where jornada_codjornada = ? order by codpartido asc");
        consulta.setInt(1, codJornada);
        ResultSet res = consulta.executeQuery();
        
        while(res.next()){
            
          Partido partido = new Partido();
          partido.setCodpartido(Integer.parseInt(res.getString("codpartido")));
          partido.setFecha(res.getDate("fecha"));
          partido.setHora(res.getString("hora"));
          partido.setJugado(Boolean.valueOf(res.getString("jugado")));
          partido.setVisitante(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipovisitante"))));
          partido.setLocal(consultarEquipoCod(Integer.parseInt(res.getString("equipo_codequipolocal"))));
          partido.setResultadoEL(Integer.parseInt(res.getString("resultadoEL")));
          partido.setResultadoEV(Integer.parseInt(res.getString("resultadoEV")));
          listaPartido.add(partido);
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaPartido;
    }
    
    /**
     * Esta función nos permite buscar la clasificación de los equipos y nos devuelve un arraylist
     */
    public static ArrayList <Equipo> clasificacionEquipos() throws Exception{
        
        ArrayList <Equipo> listaEquipos = new ArrayList();
        
       DbConnection conex = new DbConnection();
       
        PreparedStatement consulta = conex.getConnection().prepareStatement("select equipo_codequipolocal, (sum(resultadoeL) + sum(resultadoeV)) clasificacion  from partido group  by equipo_Codequipolocal order by clasificacion desc");
        ResultSet res = consulta.executeQuery();
        
        while(res.next()){
         Equipo equipo = new Equipo();
         equipo.setCodequipo(res.getInt("equipo_codequipolocal"));
         equipo.setPuntosClasificacion(res.getInt("clasificacion"));
         listaEquipos.add(equipo);
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaEquipos;
    }

    /**
     * Esta función nos permite actulizar los partidos para poder añadir los resultados de cada equipo
     */
    public static  void actualizarPartido(Partido partido) throws Exception{

       DbConnection conex = new DbConnection();

        PreparedStatement sentencia = conex.getConnection().prepareStatement(
                "UPDATE partido SET resultadoel = ? , resultadoev = ? , jugado = ? where codPartido = ? "
        );
        sentencia.setInt(1, partido.getResultadoEL());
        sentencia.setInt(2, partido.getResultadoEV());
        sentencia.setString(3, String.valueOf(partido.isJugado()));
        sentencia.setInt(4, partido.getCodpartido());
        
        sentencia.executeUpdate();
        sentencia.close();

        conex.desconectar();
    }
    /**
     * Esta función nos permite borrar un partido mediante su código en la base de datos
     */
    public static  void borrarPartido(int codPartido) throws Exception{
    
       DbConnection conex = new DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM partido WHERE codjugador = '"+codPartido+"'");
        
        conex.desconectar();
    }
}
