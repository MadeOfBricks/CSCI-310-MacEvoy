/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.awt.Label;
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
public class TimingThreadTest {
    
    public TimingThreadTest() {
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
     * Test of setText method, of class TimingThread.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        Label l_ = new Label();
        GameFrame frame = new GameFrame();
        frame.add(l_);
        SQLManage sql = new SQLManage();
        String str_ = "TEST";
        TimingThread instance = new TimingThread(frame,sql);
        instance.setText(l_, str_);
        assertEquals(l_.getText(),str_);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class TimingThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        GameFrame frame = new GameFrame();
        SQLManage sql = new SQLManage();
        TimingThread instance = new TimingThread(frame,sql);
        instance.run();
        // Game will load and run once if that test works as anticipated.
        //Window will then close
    }
    
}
