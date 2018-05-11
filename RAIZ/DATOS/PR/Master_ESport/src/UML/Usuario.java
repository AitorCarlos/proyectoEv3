
package UML;

public class Usuario {
    
    private Integer codusuario;
    private String nickname;
    private String nombre;
    private String apellido;
    private String contrasenna;
    private String permiso;

    public Usuario() {
    }
    
    public Usuario(String nickname, String nombre, String apellido, String contrasenna, String permiso) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenna = contrasenna;
        this.permiso = permiso;
    }

    public Usuario(Integer codusuario, String nickname, String nombre, String apellido, String contrasenna, String permiso) {
        this.codusuario = codusuario;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenna = contrasenna;
        this.permiso = permiso;
    }

    public Usuario(Integer codusuario, String permiso) {
        this.codusuario = codusuario;
        this.permiso = permiso;
    }

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
    
    
    
}
