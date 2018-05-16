/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Peticiones;

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
public class PeticionesTest {
    
    public PeticionesTest() {
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
     * Test of listaPeticiones method, of class Peticiones.
     */
    @Test
    public void testListaPeticiones() {
        System.out.println("listaPeticiones");
        Peticiones instance = new Peticiones();
        instance.listaPeticiones();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of aceptarPeticionDuenno method, of class Peticiones.
     */
    @Test
    public void testAceptarPeticionDuenno() {
        System.out.println("aceptarPeticionDuenno");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.aceptarPeticionDuenno(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of denegarPeticionDuenno method, of class Peticiones.
     */
    @Test
    public void testDenegarPeticionDuenno() {
        System.out.println("denegarPeticionDuenno");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.denegarPeticionDuenno(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of aceptarPeticionEquipo method, of class Peticiones.
     */
    @Test
    public void testAceptarPeticionEquipo() {
        System.out.println("aceptarPeticionEquipo");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.aceptarPeticionEquipo(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of denegarPeticionEquipo method, of class Peticiones.
     */
    @Test
    public void testDenegarPeticionEquipo() {
        System.out.println("denegarPeticionEquipo");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.denegarPeticionEquipo(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of aceptarPeticionJugador method, of class Peticiones.
     */
    @Test
    public void testAceptarPeticionJugador() {
        System.out.println("aceptarPeticionJugador");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.aceptarPeticionJugador(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of denegarPeticionJugador method, of class Peticiones.
     */
    @Test
    public void testDenegarPeticionJugador() {
        System.out.println("denegarPeticionJugador");
        int r = 0;
        Peticiones instance = new Peticiones();
        instance.denegarPeticionJugador(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
