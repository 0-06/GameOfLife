
/**
 * 
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
      
       
    
   
    
  
       
        void setup(String[]args) { // Screen size + Array initilizing
          
           cells = new int[width][height]; 
       
          
           
           
            // random function
           
      Random r = new Random();

     
      
          
           // Determines which cells are alive or dead on generation
           
           for (int x=0; x<width; x++){
               for (int y=0; y<height; y++) {
                   int state = r.nextInt(100)+1;
                   if (state > aliveProbability){
                       state = 0;
                    }
                    else {
                        state = 1;
                    }
                    
                    cells[x][y] = state;
                    if (cells[x][y] == 0)
                    
                 
                    
                         System.out.print("  ");
                    
                          if (cells[x][y] == 1)
                         System.out.print("X ");
                    
                   
                }
                
                
                System.out.println();
               
            }
            
          
        }
void iteration(int cells[][], int width, int height){ // Setting up the 'Next' Grid
    


   for (int x=0; x<width; x++){
               for (int y=0; y<height; y++) {
                   cellsBuffer[x][y] = cells[x][y];
                   
                }
             
            }
            
            for (int x=0; x<width; x++) {
                for (int y=0; y<height; y++){
                    int neighbours=0;
                    for (int xx=x-1; xx<=x+1; xx++){ // Very messy.
                        for (int yy=y-1; yy<=y+1; yy++){
                            if (((xx>=0)&&(xx<width))&&((yy>=0)&&(yy<height)))
                            {
                                if (!((xx==x)&&(yy==y))){  // Neighbour Check 
                                    if (cellsBuffer[xx][yy]==1){
                                        neighbours++;
                                    }
                                }
                            }
                            }
                        }
                        // More game rules - If less than 2 or more than 3 neighbours, die, if 3 neighbours, live
                    if(cellsBuffer[x][y]==1){
                        if (neighbours < 2 || neighbours > 3) {
                            cells[x][y] = 0;
                        }
                    }
                    else { 
                        if (neighbours == 3) {
                            cells[x][y] =1;
                        }
                        if (cells[x][y] == 0)
                    
                 
                    
                         System.out.print("  ");
                    
                          if (cells[x][y] == 1)
                         System.out.print("X ");
                    }
                    }
                    }
                    
                    }
                }
            
            


    
