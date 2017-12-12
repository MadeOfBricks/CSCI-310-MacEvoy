/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author droib
 */
public class SQLManage {
    public static void setupDBase(){
        String url = "jdbc:sqlite:C:/sqlite/TimingGame/" ;
        
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                
                
                
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        String sql= "CREATE TABLE IF NOT EXISTS scores (\n"
        + "	id integer PRIMARY KEY,\n"
        + "	score real\n"
        + ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection connectToDB(){
        String url = "jdbc:sqlite:C:/sqlite/TimingGame/";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void insertData(int score){
        //String url = "jdbc:sqlite:C:/sqlite/TimingGame/";
        String sql = "INSERT INTO scores(score) VALUES(?)";
        try (Connection conn = this.connectToDB();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    public void selectDataID(double id){
               String sql = "SELECT id, score "
                          + "FROM scores WHERE id = ?";
        
        try (Connection conn = this.connectToDB();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setDouble(1,id);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("score"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    
    
    public String allScores(){
        String sql = "SELECT id, score FROM scores ORDER BY score ASC";
        String ret = "";
        try (Connection conn = this.connectToDB();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                /*System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getInt("score") + "\t");
                */
                //System.out.println("find");
                if (rs.getInt("score") < 9000){
                    String str = Integer.toString(rs.getInt("score"));
                    if (str != "9999")
                        ret += str;
                    ret += ", ";
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ret);
        return ret;
    }
    
}
