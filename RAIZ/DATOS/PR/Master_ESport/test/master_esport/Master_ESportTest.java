/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master_esport;

import UML.Duenno;
import UML.Equipo;
import UML.Jornada;
import UML.Jugador;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1GDAW03
 */
public class Master_ESportTest {
    
    public Master_ESportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Master_ESport.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Master_ESport.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearCalendario method, of class Master_ESport.
     */
    @Test
    public void testCrearCalendario() {
        System.out.println("crearCalendario");
        String fecha = "";
        Master_ESport.crearCalendario(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearFecha method, of class Master_ESport.
     */
    @Test
    public void testCrearFecha() {
        System.out.println("crearFecha");
        String stringFecha = "";
        Date expResult = null;
        Date result = Master_ESport.crearFecha(stringFecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarFormato method, of class Master_ESport.
     */
    @Test
    public void testCambiarFormato() {
        System.out.println("cambiarFormato");
        String fecha = "";
        String expResult = "";
        String result = Master_ESport.cambiarFormato(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarDias method, of class Master_ESport.
     */
    @Test
    public void testSumarDias() {
        System.out.println("sumarDias");
        Date fechaI = null;
        ArrayList equipos = null;
        Date expResult = null;
        Date result = Master_ESport.sumarDias(fechaI, equipos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarJornada method, of class Master_ESport.
     */
    @Test
    public void testInsertarJornada() {
        System.out.println("insertarJornada");
        Date fechaI = null;
        Date fechaF = null;
        Jornada expResult = null;
        Jornada result = Master_ESport.insertarJornada(fechaI, fechaF);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarParses method, of class Master_ESport.
     */
    @Test
    public void testCargarParses() {
        System.out.println("cargarParses");
        Master_ESport.cargarParses();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarPartido method, of class Master_ESport.
     */
    @Test
    public void testInsertarPartido() {
        System.out.println("insertarPartido");
        Jornada jornada = null;
        Date fecha = null;
        String equipoLocalNombre = "";
        String equipoVisitanteNombre = "";
        Master_ESport.insertarPartido(jornada, fecha, equipoLocalNombre, equipoVisitanteNombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearMiembro method, of class Master_ESport.
     */
    @Test
    public void testCrearMiembro() throws Exception {
        System.out.println("crearMiembro");
        String nickname = "";
        String nombre = "";
        String apellido = "";
        String contrasenna = "";
        String permiso = "";
        Master_ESport.crearMiembro(nickname, nombre, apellido, contrasenna, permiso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peticionDuenno method, of class Master_ESport.
     */
    @Test
    public void testPeticionDuenno() throws Exception {
        System.out.println("peticionDuenno");
        String nickname = "";
        String nombre = "";
        String apellido = "";
        String contrasena = "";
        String permiso = "";
        String tipo = "";
        Master_ESport.peticionDuenno(nickname, nombre, apellido, contrasena, permiso, tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionDuenno method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionDuenno() throws Exception {
        System.out.println("verPeticionDuenno");
        ArrayList expResult = null;
        ArrayList result = Master_ESport.verPeticionDuenno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verTipoDuenno method, of class Master_ESport.
     */
    @Test
    public void testVerTipoDuenno() {
        System.out.println("verTipoDuenno");
        String expResult = "";
        String result = Master_ESport.verTipoDuenno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPeticion method, of class Master_ESport.
     */
    @Test
    public void testBorrarPeticion() throws Exception {
        System.out.println("borrarPeticion");
        String nickname = "";
        Master_ESport.borrarPeticion(nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionDuennos method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionDuennos() throws Exception {
        System.out.println("verPeticionDuennos");
        Master_ESport.verPeticionDuennos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirDuenno method, of class Master_ESport.
     */
    @Test
    public void testAnadirDuenno() throws Exception {
        System.out.println("anadirDuenno");
        Duenno duenno = null;
        Master_ESport.anadirDuenno(duenno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peticionEquipo method, of class Master_ESport.
     */
    @Test
    public void testPeticionEquipo() throws Exception {
        System.out.println("peticionEquipo");
        Equipo equipo = null;
        Duenno duenno = null;
        String tipo = "";
        Master_ESport.peticionEquipo(equipo, duenno, tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionEquipo method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionEquipo() throws Exception {
        System.out.println("verPeticionEquipo");
        ArrayList expResult = null;
        ArrayList result = Master_ESport.verPeticionEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verTipoEquipo method, of class Master_ESport.
     */
    @Test
    public void testVerTipoEquipo() {
        System.out.println("verTipoEquipo");
        String expResult = "";
        String result = Master_ESport.verTipoEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPeticionN method, of class Master_ESport.
     */
    @Test
    public void testBorrarPeticionN() throws Exception {
        System.out.println("borrarPeticionN");
        String nombre = "";
        Master_ESport.borrarPeticionN(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionEquipos method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionEquipos() throws Exception {
        System.out.println("verPeticionEquipos");
        Master_ESport.verPeticionEquipos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirEquipo method, of class Master_ESport.
     */
    @Test
    public void testAnadirEquipo() throws Exception {
        System.out.println("anadirEquipo");
        Equipo equipo = null;
        Master_ESport.anadirEquipo(equipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peticionJugador method, of class Master_ESport.
     */
    @Test
    public void testPeticionJugador() throws Exception {
        System.out.println("peticionJugador");
        Jugador jugador = null;
        Equipo equipo = null;
        String tipo = "";
        Master_ESport.peticionJugador(jugador, equipo, tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionJugador method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionJugador() throws Exception {
        System.out.println("verPeticionJugador");
        ArrayList expResult = null;
        ArrayList result = Master_ESport.verPeticionJugador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verTipoJugador method, of class Master_ESport.
     */
    @Test
    public void testVerTipoJugador() {
        System.out.println("verTipoJugador");
        String expResult = "";
        String result = Master_ESport.verTipoJugador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verPeticionJugadores method, of class Master_ESport.
     */
    @Test
    public void testVerPeticionJugadores() throws Exception {
        System.out.println("verPeticionJugadores");
        Master_ESport.verPeticionJugadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirJugador method, of class Master_ESport.
     */
    @Test
    public void testAnadirJugador() throws Exception {
        System.out.println("anadirJugador");
        Jugador jugador = null;
        Master_ESport.anadirJugador(jugador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
