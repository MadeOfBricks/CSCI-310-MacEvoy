/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.awt.event.KeyEvent;
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
public class KeyListenTest {
    
    public KeyListenTest() {
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
     * Test of keyPressed method, of class KeyListen.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        GameFrame frame = new GameFrame();
        SQLManage sql = new SQLManage();
        TimingThread thrd = new TimingThread(frame,sql);
        KeyEvent e = new KeyEvent(frame, 1, 20, 1, 10, 'a');
        KeyListen instance = new KeyListen(thrd);
        instance.keyPressed(e);
        System.out.println(thrd.waiting);
        if (thrd.hit || thrd.waitCommand)
            assert true;
        else
            assert false;
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class KeyListen.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        assert true;
    }

    /**
     * Test of keyTyped method, of class KeyListen.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        assert true;
    }
    
}
