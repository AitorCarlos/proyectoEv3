/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML_DB;

import java.sql.Statement;
import UML.Jornada;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import oracle.sql.DATE;

public class JornadaDB {
    
    public void registrarJornada(UML.Jornada jornada) throws Exception{
        
       DbConnection conex = new DbConnection();
  
           Statement sentencia = conex.getConnection().createStatement();
           sentencia.executeUpdate("INSERT INTO jornada (fechajornadai, fechajornadaf) VALUES (TO_DATE('"+jornada.getFechaInicio()+"', 'yy-MM-dd'), TO_DATE('"+jornada.getFechaFin()+"', 'yy-MM-dd'))");
           sentencia.close();

           conex.desconectar();
    }
    
    
    public Jornada inVerJornada(Jornada jornada)throws Exception{
    
        DbConnection conex = new  DbConnection();
        
        CallableStatement stmt = conex.getConnection().prepareCall("BEGIN in_ver_jornada(?, TO_DATE('"+jornada.getFechaInicio()+"', 'yy-MM-dd'), TO_DATE('"+jornada.getFechaFin()+"', 'yy-MM-dd')); END;");
        stmt.registerOutParameter(1, OracleTypes.INTEGER);
        stmt.execute();
        int x = stmt.getInt(1);
        
        jornada.setCodJornada(x);
        
        conex.desconectar();
        
        return jornada;
    }
    
    public Jornada consultarJornada(int codJornada) throws Exception{
        
        Jornada jornada = null;
        DbConnection conex= new  DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jornada where codjornada = ? ");
        consulta.setInt(1, codJornada);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            
            jornada = new Jornada();
            jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
            jornada.setFechaInicio(res.getDate("fechajornadai"));
            jornada.setFechaFin(res.getDate("fechajornadaf"));
        }
        else
            throw new Exception ("Jornada no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jornada;
    }
    
    public static ArrayList <Jornada> listaJornada() throws Exception{
        
        ArrayList <Jornada> listaJornada = new ArrayList();

        DbConnection conex= new  DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from jornada order by codjornada asc");
        
        while(res.next()){
            
          Jornada jornada = new Jornada();
          jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
          jornada.setFechaInicio(res.getDate("fechajornadai"));
          jornada.setFechaFin(res.getDate("fechajornadaf"));
          jornada.setPartido(PartidoDB.listaPartidoPorJornada(jornada.getCodJornada()));
          listaJornada.add(jornada);
          
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaJornada;
    }
    
        public static ArrayList <Jornada> clasificacionJornadas() throws Exception{
        
        ArrayList <Jornada> listaJornada = new ArrayList();

        DbConnection conex= new  DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from jornada order by codjornada asc");
        
        while(res.next()){
          Jornada jornada = new Jornada();
          jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
          jornada.setFechaInicio(res.getDate("fechajornadai"));
          jornada.setFechaFin(res.getDate("fechajornadaf"));
          jornada.setPartido(PartidoDB.listaPartidoPorJornada(jornada.getCodJornada()));
          listaJornada.add(jornada);
        }
        
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaJornada;
    }
    
    public void borrarJornada(int codJornada) throws Exception{
    
        DbConnection conex= new  DbConnection();
   
        Statement sentencia = conex.getConnection().createStatement();
        sentencia.executeUpdate("DELETE FROM jornada WHERE codjornada = '"+codJornada+"'");
        
        conex.desconectar();
    }
    
    public static Jornada verJornada(int codJornada) throws Exception{
        
        Jornada jornada = null;
        DbConnection conex= new  DbConnection();
   
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM jornada where codjornada = ? ");
        consulta.setInt(1, codJornada);
        ResultSet res = consulta.executeQuery();

        if(res.next()){
            jornada = new Jornada();
            jornada.setCodJornada(Integer.parseInt(res.getString("codjornada")));
            jornada.setFechaInicio(res.getDate("fechajornadai"));
            jornada.setFechaFin(res.getDate("fechajornadaf"));
            jornada.setPartido(PartidoDB.listaPartidoPorJornada(codJornada));
        }
        else
            throw new Exception ("Jornada no encontrada");
       

        res.close();
        consulta.close();
        conex.desconectar();
 
        return jornada;
    }
}
