/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author droib
 */
public class SquareThread extends Thread{
    public double num;
    String name = "Square Thread";
    SquareThread(double _num) {
        num = _num;
    }
    
    @Override
    public void run(){
        num = Math.pow(num,.5);
        message();
    }
    
    public void message(){
        System.out.println(name + " current value: " + num);
    }
}
