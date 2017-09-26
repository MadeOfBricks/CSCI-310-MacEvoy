/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cudoviste;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author droib
 */
public class CudovisteTest {
    
    public CudovisteTest() {
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
     * Test of main method, of class Cudoviste.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] args = new String[1];
        String expectedOutput  = "1\n" + "1\n" + "2\n" + "1\n" + "0\n\n";
        ByteArrayInputStream in = new ByteArrayInputStream(("4 4\n" +
"#..#\n" +
"..X.\n" +
"..X.\n" +
"#XX#").getBytes());
        //Expected result is 1 1 2 1 0
        //systemOutRule.getLog();
        System.setIn(in);
        Cudoviste.main(args);
        assertEquals(expectedOutput, outContent.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
