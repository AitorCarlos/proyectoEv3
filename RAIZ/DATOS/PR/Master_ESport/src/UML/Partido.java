/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.Date;

/**
 *
 * @author alex
 */
public class Partido {
    
    private Integer codpartido;
    private java.sql.Date fecha;
    private String hora;
    private boolean jugado;
    private Integer resultadoEL;
    private Integer resultadoEV;
    
    private Equipo local;
    private Equipo visitante;   
    private Jornada jornada;

    public Partido() {
    }
    
    public Partido(Integer codpartido) {
        this.codpartido = codpartido;
    }
    
    public Partido(java.sql.Date fecha, String hora, boolean jugado, Jornada jornada, Equipo local, Equipo visitante) {
        this.fecha = fecha;
        this.hora = hora;
        this.jugado = jugado;
        this.jornada = jornada;
        this.local = local;
        this.visitante = visitante;
        
    }
    
    public Partido(java.sql.Date fecha, String hora, boolean jugado,Equipo local, Equipo visitante, Jornada jornada, Integer resultadoEL, Integer resultadoEV) {
        this.fecha = fecha;
        this.hora = hora;
        this.jugado = jugado;
        this.local = local;
        this.visitante = visitante;
        this.jornada = jornada;
        this.resultadoEL = resultadoEL;
        this.resultadoEV = resultadoEV;
    }

    public Partido(Integer codpartido, java.sql.Date fecha, String hora, boolean jugado, Integer resultadoEL, Integer resultadoEV, Equipo local, Equipo visitante, Jornada jornada) {
        this.codpartido = codpartido;
        this.fecha = fecha;
        this.hora = hora;
        this.jugado = jugado;
        this.resultadoEL = resultadoEL;
        this.resultadoEV = resultadoEV;
        this.local = local;
        this.visitante = visitante;
        this.jornada = jornada;
    }

    public Integer getCodpartido() {
        return codpartido;
    }

    public void setCodpartido(Integer codpartido) {
        this.codpartido = codpartido;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
    
    public Integer getResultadoEL() {
        return resultadoEL;
    }

    public void setResultadoEL(Integer resultadoEL) {
        this.resultadoEL = resultadoEL;
    }

    public Integer getResultadoEV() {
        return resultadoEV;
    }

    public void setResultadoEV(Integer resultadoEV) {
        this.resultadoEV = resultadoEV;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
    
    
    
    
}
