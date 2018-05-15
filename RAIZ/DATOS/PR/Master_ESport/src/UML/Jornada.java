package UML;

import UML_DB.PartidoDB;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase jornada
 * Esta clase nos sirve para crear las distintas jornadas.
 */

public class Jornada {
    
	ArrayList <Partido> partido;
	private Integer codJornada;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;

	public Jornada() {
	}
        
        public Jornada(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
        }

        public Jornada(ArrayList<Partido> partido, Integer codJornada, java.sql.Date fechaInicio, java.sql.Date fechaFin) {
            this.partido = partido;
            this.codJornada = codJornada;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
        }

    public ArrayList<Partido> getPartido() {
        return partido;
    }

    public void setPartido(ArrayList<Partido> partido) {
        this.partido = partido;
    }

    public Integer getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(Integer codJornada) {
        this.codJornada = codJornada;
    }

    public java.sql.Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.sql.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.sql.Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(java.sql.Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Devuelve todos los partidos que hay en una jornada y su resultado
     */
    
    @Override
    public String toString() {

        String partidos="";
        for (int i = 0; i < partido.size(); i++) {
            partidos = partidos +"L:" +partido.get(i).getLocal().getNombre() +" - "+partido.get(i).getResultadoEL()+" VS "+ "V:"+partido.get(i).getVisitante().getNombre() +"-"+partido.get(i).getResultadoEV()+ "<br>";
        }
        return "<html><h1>Jornada "+ codJornada +"<h3>"+ fechaInicio +"/" + fechaFin +"</h3></h1><h1>"+ partidos + "</h1></html>}";
    }
    
}
