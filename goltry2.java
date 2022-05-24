
/**
 * 
 *
 * @author Nolan Peterson
 * @version 20/05/22
 */
import java.util.Random;
import java.util.*;

class goltry2
{

   final int aliveProbability = 5; // chance of cells being alive when created
    // array setup
    int[][] cells; // grid
    int[][] cellsBuffer;
    final int width = 20;
    final int height = 20;

   
   public void main() { // Screen size + Array initilizing
        cells = new int[width][height]; 
        cellsBuffer = new int [width][height];

        // random function
        Random r = new Random();

        // Determines which cells are alive or dead on generation
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++) {
                int state = r.nextInt(100)+1;
                if (state > aliveProbability){
                    state = 0; // dead
                }
                else {
                    state = 1; // alive
                }

                cells[x][y] = state;
                if (cells[x][y] == 0)

                    System.out.print(" ");
                if (cells[x][y] == 1)
                    System.out.print("0");

            }

            System.out.println();

        }
        // Next Grid
          System.out.println("Next Turn");
 //for (int x=0; x<width; x++){
            //for (int y=0; y<height; y++) {
           //     cellsBuffer[x][y] = cells[x][y];
//
      //   //   }
      //  }

        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++){
                int neighbours=0;

                for (int xx=x-1; xx<=x+1; xx++){ // Very messy.
                    for (int yy=y-1; yy<=y+1; yy++){
                        if (((xx>=0 && xx<width))&&((yy>=0)&&(yy<height)))
                        {
                            if (!((xx==x)&&(yy==y))){  // Neighbour Check 
                                if (cells[x][y]==1){
                                    neighbours++;
                                }
                            }
                        }
                    }
                }
                // More game rules 
                if(cellsBuffer[x][y]==1){
                    if ((neighbours < 2) || (neighbours > 3)) {
                        cells[x][y] = 0;
                    }
                }
                else { 
                    if (neighbours == 3) {
                        cells[x][y] =1;
                    }

                        if (cells[x][y] == 0)

                        System.out.print(" ");
                    if (cells[x][y] == 1)
                        System.out.print("0");
                       
                }
                
            }
                 System.out.println();       
        }
            
        }
         
        
    }


    
    
   