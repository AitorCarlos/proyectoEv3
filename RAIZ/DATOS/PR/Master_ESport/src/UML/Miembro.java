package UML;

/**
 *
 * @author Eqdaw03
 */

/**
 * Clase miembro instanciada de usuario
 * Esta clase nos sirve para crear un usuario miembro estos son los usuarios normales que solo pueden ver los resultados de las jornadas.
 */

public class Miembro extends Usuario{
    
    public Miembro() {
    }

    public Miembro(String nickname, String nombre, String apellido, String contrasenna, String permiso) {
        super(nickname, nombre, apellido, contrasenna, permiso);
    }

    
}
