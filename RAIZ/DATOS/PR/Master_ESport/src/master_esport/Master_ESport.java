
package master_esport;
import UML.*;
import UML_DB.*;
import Uml.Calendario;
import Views.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Master_ESport{
    
    static Duenno d1 = new Duenno();
    static DuennoDB d_DB;
    static PeticionDB p_DB;
    
    public static void main(String[] args) {
            //crearCalendario();
            Login login = new Login();
            login.setVisible(true);
    }
    
    public static void crearCalendario(){
         try {
            ArrayList nombresEquipos = new <String> ArrayList();
            ArrayList equipos = EquipoDB.listaEquipo();
            
            for (int i = 0; i < equipos.size(); i++) {
                Equipo e = (Equipo) equipos.get(i);
                nombresEquipos.add(e.getNombre());
            }
            new Calendario(nombresEquipos, crearFecha("2018/12/13"));

        } catch (Exception ex) {
            Logger.getLogger(Master_ESport.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static java.sql.Date crearFecha(String stringFecha){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
            Date parsed = format.parse(stringFecha);
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            return sql;
        } catch (ParseException ex) {
            Logger.getLogger(Master_ESport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static java.sql.Date sumarDias(java.sql.Date fechaI, ArrayList equipos){
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaI);
            cal.add(Calendar.DAY_OF_YEAR, 1);
            
            SimpleDateFormat format1 = new SimpleDateFormat("yy/MM/dd");
            String formatted = format1.format(cal.getTime());
            java.sql.Date fechaF = crearFecha(formatted);
            return fechaF;
    }
    
    public static Jornada insertarJornada(java.sql.Date fechaI, java.sql.Date fechaF){
        Jornada jornada = new Jornada(fechaI, fechaF);
        try {
            jornada = new JornadaDB().inVerJornada(jornada);
        } catch (Exception ex) {
            Logger.getLogger(Master_ESport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jornada;
    }
    
    public static void insertarPartido(Jornada jornada, java.sql.Date fecha, String equipoLocalNombre, String equipoVisitanteNombre){
    try {
        Partido partido = new Partido();
        partido.setFecha(jornada.getFechaInicio());
        partido.setHora("14:00");
        partido.setJugado(false);
        
        Equipo equipoLocal = EquipoDB.consultarEquipoNom(equipoLocalNombre);
        Equipo equipoVisitante = EquipoDB.consultarEquipoNom(equipoVisitanteNombre);
        new PartidoDB().registrarPartido(partido, jornada,equipoVisitante, equipoLocal);
    } catch (Exception ex) {
        Logger.getLogger(Master_ESport.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    //Crear miembro alias usuario
    public static void crearMiembro(String nickname, String nombre, String apellido, String contrasenna, String permiso) throws Exception{
    
        Miembro m1 = new Miembro(nickname, nombre, apellido, contrasenna, permiso);
        
        MiembroDB.registrarUsuario(m1);

    }

        //Crear peticion dueño
    public static void peticionDuenno(String nickname, String nombre, String apellido, String contrasena, String permiso, String tipo) throws Exception{
    
        p_DB = new PeticionDB();
        
        d1.setNickname(nickname);
        d1.setNombre(nombre);
        d1.setApellido(apellido);
        d1.setContrasenna(contrasena);
        d1.setPermiso(permiso);
        
        p_DB.peticionDuenno(d1, tipo);
    }
    //Ver peticion dueño
    public static Duenno verPeticionDuenno() throws Exception{
    
        p_DB = new PeticionDB();
        
        return p_DB.consultarDuenno();
    }
    //Ver que tipo de peticion se ha realizado
    public static String verTipo(){
        
        return PeticionDB.tipo;
    }
    //Borrar una peticion por su nickname
    public static void borrarPeticion(String nickname) throws Exception{
        
        p_DB.borrarPeticionDJ(nickname);
    }
    //Ver todas las peticiones de dueños que hay
    public static ArrayList verPeticionDuennos() throws Exception{
    
        p_DB = new PeticionDB();
        
        return p_DB.listaPetiDuenno();
    }
    //Aceptar peticion de dueño y añadirlo como dueño en la base de datos
    public static void anadirDuenno(Duenno duenno) throws Exception{
    
        d_DB = new DuennoDB();

        d_DB.registrarDuenno(duenno);
    }
}
