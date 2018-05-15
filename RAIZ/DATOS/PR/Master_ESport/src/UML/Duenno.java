package UML;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase dueño instanciada de usuario
 * Esta clase nos sirve para crear un usuario dueño.
 */
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
