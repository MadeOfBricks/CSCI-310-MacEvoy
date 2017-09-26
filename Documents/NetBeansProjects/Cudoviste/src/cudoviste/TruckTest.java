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
public class TruckTest {

    private int height, width;
    private char[][] map;
    private int[] squashSpots = new int[5];

    public TruckTest(char[][] arr, int thisWidth, int thisHeight) {
        height = thisHeight;
        width = thisWidth;
        map = arr;
    }
    
    public void printRunResult(){
            for(int i =0;i<5;i++){
                System.out.println(squashSpots[i]);
            }
        
    }

    public void run() {
        int rHeight = 0, rWidth = 0, i, hits;
        boolean valid = true;
        char[] checkPoints = new char[4];
        while (rHeight < height - 1) {
            while (rWidth < width - 1) {
                hits = 0;
                valid = true;
                //System.out.println("Checking towards: " + Integer.toString(rWidth + 1) 
                //        + "," + Integer.toString(rHeight + 1));
                checkPoints[0] = map[rWidth][rHeight];
                checkPoints[1] = map[rWidth + 1][rHeight];
                checkPoints[2] = map[rWidth][rHeight + 1];
                checkPoints[3] = map[rWidth + 1][rHeight + 1];
                for (i = 0; i < 4; i++) {
                    char point = checkPoints[i];
                    if (point == '#') {
                        i = 4;
                        valid = false;
                    } else if (point == 'X') {
                        hits++;
                    }
                }
                
                if (valid){
                    squashSpots[hits]++;
                }

                rWidth++;
            }
            rWidth = 0;
            rHeight++;

        }
        
        printRunResult();
    }
}
