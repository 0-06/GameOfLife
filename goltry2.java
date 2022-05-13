
/**
 * Line 32 & 57 throwing erors. Commented out.
 *
 * @author Nolan Peterson
 * @version 13/05/22
 */
import java.util.Random;
import java.util.*;



 class goltry2
{
    // instance variables - replace the example below with your own
   int cellSize = 10; // size of grid square
        float aliveProbability = 15; // chance of cells being alive when created
        
        // array setup
       int[][] cells;
       int[][] cellsBuffer;
       int width = 20;
       int height = 20;
      
       
    
   
    
  
       
        void setup () { // Screen size + Array initilizing
          // size (20,20);
           cells = new int[width/cellSize][height/cellSize]; 
           cellsBuffer = new int[width/cellSize][height/cellSize];
          
           
           
            // random functions
            Random rand = new Random();
      int upperbound = 100;

      float float_random=rand.nextFloat();
           
           // Determines which cells are alive or dead on generation
           
           for (int x=0; x<width/cellSize; x++){
               for (int y=0; y<height/cellSize; y++) {
                   float state = float_random;
                   if (state > aliveProbability){
                       state = 0;
                    }
                    else {
                        state = 1;
                    }
                    //cells[x][y] = int(state);
                }
               
            }
            
          // background(0);
        }
void iteration(){
    for (int x=0; x<width/cellSize; x++){
        for (int y=0;y<height/cellSize;y++){
            cellsBuffer[x][y] = cells[x][y];
        }
    }


   
 
 
}
}
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    

