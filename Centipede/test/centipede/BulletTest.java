/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package centipede;

import java.awt.Graphics;
import java.awt.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class BulletTest {

    public BulletTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class Bullet.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Bullet instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Bullet.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Display display = null;
        int id = 0;
        Bullet instance = null;
        instance.update(display, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Bullet.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        String img = "";
        Bullet instance = null;
        Image expResult = null;
        Image result = instance.getImage(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeltaY method, of class Bullet.
     */
    @Test
    public void testGetDeltaY() {
        System.out.println("getDeltaY");
        Bullet instance = null;
        int expResult = 0;
        int result = instance.getDeltaY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeltaY method, of class Bullet.
     */
    @Test
    public void testSetDeltaY() {
        System.out.println("setDeltaY");
        int deltaY = 0;
        Bullet instance = null;
        instance.setDeltaY(deltaY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShip method, of class Bullet.
     */
    @Test
    public void testGetShip() {
        System.out.println("getShip");
        Bullet instance = null;
        Ship expResult = null;
        Ship result = instance.getShip();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShip method, of class Bullet.
     */
    @Test
    public void testSetShip() {
        System.out.println("setShip");
        Ship ship = null;
        Bullet instance = null;
        instance.setShip(ship);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}