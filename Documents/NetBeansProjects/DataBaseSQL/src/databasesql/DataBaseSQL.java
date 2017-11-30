/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesql;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droib
 */
public class DataBaseSQL {

    public static void createNewDatabase(String fname){
        String url = "jdbc:sqlite:C:/sqlite/db/" + fname;
        
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public static void createNewTable(String DBUrl){
        
        String sql= "CREATE TABLE IF NOT EXISTS picnic (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(DBUrl);
                Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection connectToDB(String DBUrl){
        String url = DBUrl;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void insertData(String DBUrl, String name, double capacity){
        String sql = "INSERT INTO picnic(name,capacity) VALUES(?,?)";
        try (Connection conn = this.connectToDB(DBUrl);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void selectAllData(String DBUrl){
        String sql = "SELECT id, name, capacity FROM picnic";
        
        try (Connection conn = this.connectToDB(DBUrl);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    
    public void selectDataID(String DBUrl, double id){
               String sql = "SELECT id, name, capacity "
                          + "FROM picnic WHERE id = ?";
        
        try (Connection conn = this.connectToDB(DBUrl);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setDouble(1,id);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void selectDataName(String DBUrl, String name){
        String sql = "SELECT id, name, capacity "
        + "FROM picnic WHERE name = ?";
        
        try (Connection conn = this.connectToDB(DBUrl);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,name);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateData(String DBUrl, int id, String name, double value){
        String sql = "UPDATE picnic SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";
        
        try (Connection conn = this.connectToDB(DBUrl);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            pstmt.setString(1, name);
            pstmt.setDouble(2, value);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        //createNewDatabase(url);
        //createNewTable(url);
        DataBaseSQL app = new DataBaseSQL();
        String url = "jdbc:sqlite:C:/sqlite/db/forTest.db";
        app.connectToDB(url);
        //app.insertData(url, "Sandwiches", 100);
        //app.insertData(url, "Big Chip Bags", 40);
        //app.insertData(url, "Apples", 999);
        app.selectAllData(url);
        
    }
    
    
    
    /*
    
    private Connection connection = null;
    
    public Connection getConnection(){
        if (connection == null){
            synchronized(this){
                if (connection == null){
                    try{
                        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                    } catch (SQLException ex){
                        Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    void run(){
        //Add new car to the server
        System.out.println("run unimp");
    }
    */
    
}
