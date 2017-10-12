/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionstest;
import java.util.AbstractCollection;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author droib
 */
public class CollectionsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Set<Bag> bags = new TreeSet < Bag> ();
        
        
        bags.add(new RelayBag(1.3));
        bags.add(new RelayBag(2.4));
        bags.add(new RelayBag(4.4));
        
        for(Bag bag : bags){
            System.out.println("A Bag with a " + bag.number() + ".");
        }
        
        
    }
    
}
