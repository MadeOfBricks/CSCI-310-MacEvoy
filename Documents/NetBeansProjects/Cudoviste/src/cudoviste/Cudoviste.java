/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cudoviste;

/**
 *
 * @author droib
 */
import java.util.Scanner;
import java.io.*;
public class Cudoviste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        InputStreamReader cin = null;

        cin = new InputStreamReader(System.in);
        char[][] map;
        int width=0,height=0;
        String str = "";
        //System.out.println("Enter two ints for map size.");
        //height = scan.nextInt();
        //width = scan.nextInt();
        while (height ==0){
            char r = (char) cin.read();
            if (!Character.isWhitespace(r))
                str += r;
            else
                height = Integer.parseInt(str);
        }
        
        str = "";
        
        while (width ==0){
            char r = (char) cin.read();
            if (!Character.isWhitespace(r))
                str += r;
            else
                width = Integer.parseInt(str);
        }
        
        
            
        //System.out.println("Width: " + width + " Height: " + height);
        
        map = new char[width][height];
        int rWidth=0,rHeight=0;
        while(rHeight < height){
            while (rWidth < width){
                char c = (char) cin.read();
                if (!Character.isWhitespace(c)){
                    map[rWidth][rHeight] = c;
                    rWidth++;
                }
            }
            rWidth = 0;
            rHeight++;
            
        }
        //System.out.println();
        //System.out.println();
        //System.out.println("Map complete! Drawing . . .");
        
        rWidth=0;
        rHeight=0;
        char mapC;
        while(rHeight < height){
            while (rWidth < width){
                mapC = map[rWidth][rHeight];
                //System.out.print(rWidth + "," + rHeight + " ");     
                //System.out.print(mapC);  
                //System.out.print("   ");
                
                rWidth++;
            }
            //System.out.println();
            rWidth = 0;
            rHeight++;
            
        }
        //System.out.println();
        //System.out.println();
        
        TruckTest truck;
        truck = new TruckTest(map,width,height);
        truck.run();
        
    }
    
}
