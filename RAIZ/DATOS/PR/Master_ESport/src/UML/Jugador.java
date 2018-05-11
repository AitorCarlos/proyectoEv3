/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 *
 * @author alex
 */
public class Jugador {
    
    private Integer codjugador;
    private String nombre;
    private String apellido;
    private String nickname;
    private Double sueldo;
    
    private Equipo equipo;

    public Jugador() {
    }
    
    public Jugador(String nombre, String apellido, String nickname, Double sueldo) {
        this.codjugador = codjugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
    }

    public Jugador(Integer codjugador, String nombre, String apellido, String nickname, Double sueldo) {
        this.codjugador = codjugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
    }

    public Jugador(Integer codjugador, String nombre, String apellido, String nickname, Double sueldo, Equipo equipo) {
        this.codjugador = codjugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }

    public Integer getCodjugador() {
        return codjugador;
    }

    public void setCodjugador(Integer codjugador) {
        this.codjugador = codjugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return  "Nickname=" + nickname + "  Nombre=" + nombre + "  Apellido=" + apellido;
    }
    
    
    
}
