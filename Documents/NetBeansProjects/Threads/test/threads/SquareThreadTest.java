/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

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
public class SquareThreadTest {
    
    public SquareThreadTest() {
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
     * Test of run method, of class SquareThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        double num = 4;
        SquareThread instance = new SquareThread(num);
        instance.run();
        assertEquals(instance.num,Math.pow(num,.5),.5);
    }

    /**
     * Test of message method, of class SquareThread.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        double num = 4.0;
        SquareThread instance = new SquareThread(num);
        instance.message();
        System.out.println("Should be 4");
        instance.run();
        System.out.println("Should be 2");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
