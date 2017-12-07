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
public class FactorsThreadTest {
    
    public FactorsThreadTest() {
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
     * Test of run method, of class FactorsThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        int num = 3;
        FactorsThread instance = new FactorsThread(num);
        instance.run();
        assertEquals(instance.num,num + num);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of message method, of class FactorsThread.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        int num = 2;
        FactorsThread instance = new FactorsThread(2);
        instance.message();
        System.out.println("Should be 2");
        instance.run();
        System.out.println("Should be 4");
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
