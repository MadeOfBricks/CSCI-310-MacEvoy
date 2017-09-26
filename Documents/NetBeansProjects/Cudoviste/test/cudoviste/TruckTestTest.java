/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cudoviste;

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
public class TruckTestTest {
    
    public TruckTestTest() {
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
     * Test of printRunResult method, of class TruckTest.
     */
    @Test
    public void testPrintRunResult() {
        System.out.println("printRunResult");
        char[][] chars = new char[3][3];
        TruckTest instance = new TruckTest(chars,3,3);
        instance.printRunResult();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class TruckTest.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        char[][] chars = new char[3][3];
        TruckTest instance = new TruckTest(chars,3,3);
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
