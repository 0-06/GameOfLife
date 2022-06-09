/**
 * 
 *
 * @author Nolan Peterson
 * @version 9/06/22
 */
import java.util.Random;
import java.util.Timer; 
import java.util.Scanner;
import java.util.TimerTask; 

public class goltry2
{

    //static int[][] cells; // grid
    static final int WIDTH = 22;
    static final int HEIGHT = 22;
    static int [][] test;

    static int [][]cells;
    static String deadCell;
    static  String aliveCell;
    // array setup

    public static void main(String[] args) { 
        String command;
        boolean quit = false;
        int turnNumber = 1;
        boolean auto = false;
       int autoDuration = 0;
        int autoNum = 0;
        cells = new int [WIDTH][HEIGHT];
       
        // Keyboard Scanner
        Scanner keyboard = new Scanner(System.in);

        // Setting variables
        System.out.println("What would you like the dead cells to look like?");
        deadCell =keyboard.nextLine();
        System.out.println("What would you like the alive cells to look like?");
        aliveCell =keyboard.nextLine();

        System.out.println("How likely would you like the cells to be alive on generation? (e.g. 5 for a 5% chance)");
        int aliveProbability = keyboard.nextInt(); // chance of cells being alive when created

        // random function
        Random r = new Random();

        // Determines which cells are alive or dead on generation
        for (int x=1; x<WIDTH-1; x++){
            for (int y=1; y<HEIGHT-1; y++) { // Creating phantom cells that aren't printed to prevent crashes
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
        System.out.println();
        // User interaction switch statement

        System.out.println("Type 'Next' to advance");
        while (quit == false){
            command=keyboard.nextLine();
            switch(command){
                case "auto":  auto = true;
                System.out.println("How many turns would you like it to be automatic for?");
                autoNum = keyboard.nextInt();
                while (auto == true){ 
                    if (autoDuration <= autoNum) try {
                            Thread.sleep(500);
                            System.out.println("Turn #"+turnNumber);
                            turnNumber++;
                            autoDuration++;
                            nextGen();
                        } catch (Exception e) {
                           
                        }
                        if (autoDuration > autoNum) {
                         auto=false;
                         autoDuration=1;
                        } 
                    }
                

                break;
                
                case "next":

                System.out.println("Turn #"+turnNumber);
                turnNumber++;
                nextGen();
                break;
                case "quit": quit = true; auto = false;
                break;
                case "": 
                break;
                default: 
                System.out.println("Invalid Command");
                break;

            }
        } keyboard.close();
    }

    public static void nextGen(){

        for (int x=1; x<WIDTH-1; x++){
            for (int y=1; y<HEIGHT-1; y++) {// Creating phantom cells that aren't printed to prevent crashes
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
