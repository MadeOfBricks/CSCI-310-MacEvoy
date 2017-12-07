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
public class FactorsThread extends Thread{
    public int num;
    String name = "Factor Thread";
    FactorsThread(int _num) {
        num = _num;
    }
    
    @Override
    public void run(){
        num += num; 
        message();
    }
    
    public void message(){
        System.out.println(name + " current value: " + num);
    }
}
