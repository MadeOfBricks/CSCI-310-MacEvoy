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
public class KeyListen extends Frame implements KeyListener {
    TimingThread myThread;
    
    public KeyListen(TimingThread myThread_){  
        myThread = myThread_;
    } 
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (myThread.waiting){
                myThread.waitCommand = true;
                myThread.setText(myThread.myFrame.topLabel,"No mashing!");
            } else 
                    myThread.hit = true;
        }
    } 
    
    @Override
    public void keyReleased(KeyEvent e) {  
        
    }  
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    
}
