
/**
 * 
 *
 * @author Nolan Peterson
 * @version 27/05/22
 */
import java.util.Random;

import java.util.Scanner;
class goltry2
{

   
    // array setup
    int[][] cells; // grid
    
    final int width = 22;
    final int height = 22;
    
 String deadCell;
    String aliveCell;
   
   public void main() { 
        
       cells = new int[width][height]; 
         try (// Keyboard Scanner
        Scanner keyboard = new Scanner(System.in)) {
            // Setting variables
            System.out.println("What would you like the dead cells to look like?");
            String deadCell =keyboard.nextLine();
            System.out.println("What would you like the alive cells to look like?");
            String aliveCell =keyboard.nextLine();
      
            System.out.println("How likely would you like the cells to be alive on generation? (e.g. 5 for a 5% chance)");
            int aliveProbability = keyboard.nextInt(); // chance of cells being alive when created
     
    
    
            // random function
            Random r = new Random();

            // Determines which cells are alive or dead on generation
            for (int x=1; x<21; x++){
                for (int y=1; y<21; y++) { // Creating phantom cells that aren't printed to prevent crashes
                    int state = r.nextInt(100)+1;
                    if (state > aliveProbability){
                        state = 0; // dead
                    }
                    else {
                        state = 1; // alive
                    }
                       
                    cells[x][y] = state; // print dead/alive cells
                    if (cells[x][y] == 0)

                        System.out.print(deadCell+ " ");
                    if (cells[x][y] == 1)
                        System.out.print(aliveCell+ " ");

                }

                System.out.println();

            }
            // Next Grid
              System.out.println("Next Turn");
 

            for (int x=1; x<21; x++) {
                for (int y=1; y<21; y++){ // Creating phantom cells that aren't printed to prevent crashes
                    int neighbours=0;
                 //*** Neighbour check and bump 
                
            if (cells[x][y+1]==1) {
                neighbours++;
            }
            if (cells[x][y-1]==1) {
                neighbours++;
            }
            if (cells[x+1][y+1]==1) {
                neighbours++;
            }
            if (cells[x+1][y-1]==1) {
                neighbours++;
            }
            if (cells[x+1][y]==1) {
                neighbours++;
            }
            if (cells[x-1][y+1]==1) {
                neighbours++;
            }
            if (cells[x-1][y]==1) {
                neighbours++;
            }
            if (cells[x-1][y-1]==1) {
                neighbours++;
            }

                    //  game rules 
                    if(cells[x][y]==1){
                        if ((neighbours < 2) || (neighbours > 3)) { // If a cell has less than 2 or more than 3 neighbours, Die
                            cells[x][y] = 0;
                        }
                    }
                    else { 
                        if (neighbours == 3) { // If a cell has 3 neighbours, become a live cell.
                            cells[x][y] =1;
                        }
                        // If not, remain the same
                    }
                    // Print grid
                            if (cells[x][y] == 0){
                                    
                            System.out.print(deadCell+" ");
                        }
                        if (cells[x][y] == 1){
                            
                            System.out.print(aliveCell+ " ");
                        }
                           
                    }
                    System.out.println();
                }
        }
                        
        }
            
        }
    
        
    


    
    
   