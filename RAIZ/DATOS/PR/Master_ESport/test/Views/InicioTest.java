/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import UML.Usuario;
import javax.swing.JButton;
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
public class InicioTest {
    
    public InicioTest() {
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
     * Test of getUsuario method, of class Inicio.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Inicio instance = new Inicio();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class Inicio.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        Inicio instance = new Inicio();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of permisos method, of class Inicio.
     */
    @Test
    public void testPermisos() {
        System.out.println("permisos");
        String permiso = "";
        Inicio instance = new Inicio();
        instance.permisos(permiso);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AltaUsuarioPanel method, of class Inicio.
     */
    @Test
    public void testAltaUsuarioPanel() {
        System.out.println("AltaUsuarioPanel");
        Inicio instance = new Inicio();
        instance.AltaUsuarioPanel();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of InicioPanel method, of class Inicio.
     */
    @Test
    public void testInicioPanel() {
        System.out.println("InicioPanel");
        Inicio instance = new Inicio();
        instance.InicioPanel();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AdministradorPanel method, of class Inicio.
     */
    @Test
    public void testAdministradorPanel() {
        System.out.println("AdministradorPanel");
        Inicio instance = new Inicio();
        instance.AdministradorPanel();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Inicio.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Inicio.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
