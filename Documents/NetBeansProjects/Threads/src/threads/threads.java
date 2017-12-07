/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import java.util.Scanner;

public class threads {

    String[] args;

    threads(String[] _args) {
        args = _args;
    }

    public static void main(String[] args) throws Exception {
        new threads(args).run();
    }

    void run() throws Exception {
        int myNum = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to exponentiate and square root 4 times.");
        myNum = scan.nextInt();
        
        FactorsThread fac = new FactorsThread(myNum);
        SquareThread sqr = new SquareThread(myNum);
        
        fac.start();
        sqr.start();
        
        for(int i = 0;i<10;i++){
            fac.run();
            sqr.run();
        }
        
        System.out.println(myNum);
         
    }

}
