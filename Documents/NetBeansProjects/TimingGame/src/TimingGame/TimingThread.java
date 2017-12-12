/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.awt.Label;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droib
 */
public class TimingThread extends Thread{
    GameFrame myFrame;
    SQLManage sql;
    double waitTimer;
    int milliTimer;
    boolean running = true, waiting = true, waitCommand = true
    ,gameDone = false;
    public boolean hit = false;
    public TimingThread(GameFrame gFrame, SQLManage sql_){
        myFrame = gFrame;
        myFrame.kListen.myThread = this;
        sql = sql_;
    }
    
    public void setText(Label l_,String str_){
        myFrame.setText(l_,str_);
    }
    
    
    @Override
    public void run(){
        
        while (waitCommand){
            waitTimer = Math.random() * 2000 + 2000;
            waitCommand = false;
            setText(myFrame.topLabel, "Wait . . .");
            try{
                Thread.sleep((long) waitTimer);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        myFrame.setText(myFrame.topLabel,"HIT SPACE");
        waiting = false;
        
        while (milliTimer < 3000 && !hit){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            milliTimer++;
            setText(myFrame.timeLabel,Integer.toString(milliTimer));
        }
        
        if (hit){
            setText(myFrame.topLabel,"HIT");
            setText(myFrame.timeLabel
                    ,"You reacted within " + Integer.toString(milliTimer) + " milliseconds.");
        }else
            setText(myFrame.topLabel,"MISS");
        
        
        
        gameDone = true;
        System.out.println(sql.allScores());
        sql.insertData(milliTimer);
        setText(myFrame.scoreLabel,"Scores: " + sql.allScores());
        //frame.setText(frame.scoreLabel,Sql.allScores());
        
    }
    
    
}
