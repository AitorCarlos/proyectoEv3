/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

public class Duenno extends Usuario{

    private Equipo equipo;
    
    
    public Duenno() {
    }

    
    public Duenno(String nickname, String nombre, String apellido, String contrasenna, String permiso) {
        super(nickname, nombre, apellido, contrasenna, permiso);
        this.equipo = equipo;
    }

    public Duenno(String nombre, Equipo equipo) {
        this.equipo = equipo;
    }



    public Duenno(String nombre, Equipo equipo, Integer codusuario, String permiso) {
        super(codusuario, permiso);
        this.equipo = equipo;
    }
    



    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
}
