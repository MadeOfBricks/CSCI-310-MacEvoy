/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.awt.Label;
import java.awt.event.WindowEvent;
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
public class GameFrameTest {
    
    public GameFrameTest() {
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
     * Test of setText method, of class GameFrame.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        Label l_ = new Label();
        String str_ = "TEST";
        GameFrame instance = new GameFrame();
        instance.add(l_);
        instance.setText(l_, str_);
        
        assertEquals(l_.getText(),str_);
        
        System.out.println(l_.getText());
        System.out.println(str_);
        
    }

    /**
     * Test of windowClosed method, of class GameFrame.
     */
    
    @Test
    public void testWindowClosed() {
        System.out.println("windowClosed");
        GameFrame frame = new GameFrame();
        SQLManage sql = new SQLManage();
        WindowEvent e = new WindowEvent(frame,WindowEvent.WINDOW_CLOSED);
        TimingThread thrd = new TimingThread(frame,sql);
        //Frame continues to close as anticipated
    }
    
}
