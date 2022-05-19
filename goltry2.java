
/**
 * Line 32 & 57 throwing erors. Commented out.
 *
 * @author Nolan Peterson
 * @version 19/05/22
 */
import java.util.Random;
import java.util.*;



 class goltry2
{
   
   
        int aliveProbability = 15; // chance of cells being alive when created
        
        // array setup
       int[][] cells;
       int[][] cellsBuffer;
       int width = 20;
       int height = 20;
      
        int max = 100;
        int min = 1;
        int range = max - min + 1;
    
   
    
  
       
        void setup(String[]args) { // Screen size + Array initilizing
          
           cells = new int[width][height]; 
       
          
           
           
            // random functions
           
      Random r = new Random();

     
      
          
           // Determines which cells are alive or dead on generation
           
           for (int x=0; x<width; x++){
               for (int y=0; y<height; y++) {
                   int state = r.nextInt(100)+1;
                   if (state > 15){
                       state = 0;
                    }
                    else {
                        state = 1;
                    }
                    
                    cells[x][y] = state;
                    if (cells[x][y] == 0)
                    
                 
                    
                         System.out.print("#");
                    
                          if (cells[x][y] == 1)
                         System.out.print(" ");
                    
                   
                }
                
                
                System.out.println();
               
            }
            
          
        }
void iteration(){
    for (int x=0; x<width; x++){
        for (int y=0;y<height;y++){
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
    

