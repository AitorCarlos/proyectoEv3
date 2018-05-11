/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Equipo {
    
    private Integer codequipo;
    private String nombre;
    private Integer puntosClasificacion;
    private Duenno duenno;   
    private ArrayList <Jugador> jugador;

    public Equipo() {
    }

    public Equipo(String nombre, Duenno duenno) {
        this.nombre = nombre;
        this.duenno = duenno;
    }
    
    public Equipo(Integer codequipo, String nombre) {
        this.codequipo = codequipo;
        this.nombre = nombre;
    }

    public Equipo(Integer codequipo, String nombre, Duenno duenno, ArrayList<Jugador> jugador) {
        this.codequipo = codequipo;
        this.nombre = nombre;
        this.duenno = duenno;
        this.jugador = jugador;
    }

    public Integer getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(Integer codequipo) {
        this.codequipo = codequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Duenno getDuenno() {
        return duenno;
    }

    public void setDuenno(Duenno duenno) {
        this.duenno = duenno;
    }

    public ArrayList<Jugador> getJugador() {
        return jugador;
    }

    public void setJugador(ArrayList<Jugador> jugador) {
        this.jugador = jugador;
    }

    public Integer getPuntosClasificacion() {
        return puntosClasificacion;
    }

    public void setPuntosClasificacion(Integer puntosClasificacion) {
        this.puntosClasificacion = puntosClasificacion;
    }

    @Override
    public String toString() {
        return "Equipo{" + "codequipo=" + codequipo + ", nombre=" + nombre + ", puntosClasificacion=" + puntosClasificacion + ", duenno=" + duenno + ", jugador=" + jugador + '}';
    }
    
    public String toStringClasificacion() {
        return  nombre + " - " + puntosClasificacion + "puntos";
    }
    
}
