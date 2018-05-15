package UML;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase admin instanciada de usuario.
 * Esta clase nos sirve para crear un usuario administrador.
 */
public class Admin extends Usuario{
    
    public Admin() {
    }

    public Admin(String nickname, String nombre, String apellido, String contrasenna, String permiso) {
        super(nickname, nombre, apellido, contrasenna, permiso);
    }
    
}
