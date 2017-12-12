/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TimingGame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import javax.swing.JFrame;

public class TimingGame {

    String[] args;

    TimingGame() {
    }

    public static void main(String[] args) throws Exception {
        new TimingGame().run();
    }
    
    

    void run() throws Exception {
        SQLManage Sql = new SQLManage();
        GameFrame frame = new GameFrame();
        //Allow frame to close
        frame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                System.exit(0);
            }
        } );
        
        TimingThread tThread = new TimingThread(frame, Sql);
        
        tThread.start();
        frame.setText(frame.topLabel,"Wait . . .");
        
        
        
        File dir = new File("C:/sqlite/TimingGame/");
        if (!dir.exists()){
            SQLManage.setupDBase();
            Sql.insertData(9999);
        }
        
        
    }

}
