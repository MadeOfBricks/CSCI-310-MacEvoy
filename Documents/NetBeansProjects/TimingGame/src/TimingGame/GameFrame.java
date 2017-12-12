/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingGame;

import java.awt.event.KeyEvent;
import java.awt.*;  
import java.awt.event.*;  
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author droib
 */
public class GameFrame extends Frame{
    Label topLabel,timeLabel, scoreLabel;  
    TextArea area;  
    TimingThread myThread;
    KeyListen kListen = new KeyListen(myThread);
    
    
    public GameFrame(){
        
        topLabel=new Label();
        timeLabel = new Label();
        scoreLabel = new Label();
        
        topLabel.setBounds(20,50,200,20);
        timeLabel.setBounds(20,70,200,20);
        scoreLabel.setBounds(20,90,205,100);
        area=new TextArea();  
        area.setBounds(20,400,0, 0); 
        area.addKeyListener(kListen);  
          
        add(topLabel);
        add(timeLabel);
        add(scoreLabel);
        add(area);
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
        topLabel.setText("");
        timeLabel.setText("0");
        scoreLabel.setText("");
    }
    
    void setText(Label l_,String str_){
        l_.setText(str_);
    }
    
    public void windowClosed(WindowEvent e){
        System.exit(0);
        dispose();
    }
    
    
    
}
