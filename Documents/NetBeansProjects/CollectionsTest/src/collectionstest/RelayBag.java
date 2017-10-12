/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionstest;

/**
 *
 * @author droib
 */
public class RelayBag implements Bag{
    private final double myNum;
    public RelayBag(double num){
        myNum = num;
    }
    
    @Override
    public double number(){
        return myNum;
    }
    
    @Override
    public int compareTo(Bag bag){
        if (bag instanceof RelayBag){
            RelayBag rBag = (RelayBag) bag;
            
            if (myNum > rBag.number()) return 1;
            if (myNum < rBag.number()) return -1;
            else
                return 0;
        }else {
            return this.getClass().getName().compareTo(bag.getClass().getName());
        }
    }
}
