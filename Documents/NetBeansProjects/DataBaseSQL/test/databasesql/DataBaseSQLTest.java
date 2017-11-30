/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DataBaseSQLTest {
    
    public DataBaseSQLTest() {
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
     * Test of createNewDatabase method, of class DataBaseSQL.
     */
    @Test
    public void testCreateNewDatabase() {
        System.out.println("createNewDatabase");
        String fname = "ForTests.db";
        DataBaseSQL.createNewDatabase(fname);
        String url = "jdbc:sqlite:C:/sqlite/db/" + fname;
        
        try (Connection conn = DriverManager.getConnection(url)){
            System.out.println("DB created");
            assert(true);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            assert(false);
        }
        
    }

    /**
     * Test of createNewTable method, of class DataBaseSQL.
     */
    @Test
    public void testCreateNewTable() {
        System.out.println("createNewTable");
        String fname = "ForTests.db";
        DataBaseSQL.createNewTable(fname);
        String url = "jdbc:sqlite:C:/sqlite/db/" + fname;
        Statement result = null;
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            stmt.executeQuery("PRAGMA table_info(your_table_name)");
            result = stmt;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        assert(result != null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of connectToDB method, of class DataBaseSQL.
     */
    @Test
    public void testConnectToDB() {
        System.out.println("connectToDB");
        DataBaseSQL instance = new DataBaseSQL();
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        Connection connect;
        try(Connection conn = DriverManager.getConnection(url)){
            connect = DriverManager.getConnection(url);
            assert(true);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            assert(false);
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertData method, of class DataBaseSQL.
     */
    @Test
    public void testInsertData() {
        System.out.println("insertData");
        String name = "testdat";
        double capacity = 2.0;
        DataBaseSQL instance = new DataBaseSQL();
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        instance.connectToDB(url);
        instance.insertData(url,name, capacity);
        instance.selectDataName(url, name);
        
    }

    /**
     * Test of selectAllData method, of class DataBaseSQL.
     */
    @Test
    public void testSelectAllData() {
        System.out.println("selectAllData");
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        DataBaseSQL instance = new DataBaseSQL();
        instance.selectAllData(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectDataID method, of class DataBaseSQL.
     */
    @Test
    public void testSelectDataID() {
        System.out.println("selectDataID");
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        double id = 0.0;
        DataBaseSQL instance = new DataBaseSQL();
        Connection connect = instance.connectToDB(url);
        instance.selectDataID(url,id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectDataName method, of class DataBaseSQL.
     */
    @Test
    public void testSelectDataName() {
        System.out.println("selectDataName");
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        String name = "";
        DataBaseSQL instance = new DataBaseSQL();
        instance.selectDataName(url,name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateData method, of class DataBaseSQL.
     */
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        int id = 0;
        String name = "";
        double value = 0.0;
        DataBaseSQL instance = new DataBaseSQL();
        instance.updateData(url,id, name, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DataBaseSQL.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        args[0] = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        DataBaseSQL.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
