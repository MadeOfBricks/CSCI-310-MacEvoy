/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionstest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author droib
 */
public class RelayBagTest {
    
    public RelayBagTest() {
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
     * Test of number method, of class RelayBag.
     */
    @Test
    public void testNumber() {
        System.out.println("number");
        RelayBag instance = new RelayBag(0);
        double expResult = 0.0;
        double result = instance.number();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class RelayBag.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Bag bag = new RelayBag(1.2);
        RelayBag instance = new RelayBag(1.2);
        int expResult = 0;
        int result = instance.compareTo(bag);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
