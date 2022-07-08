/**
 * 
 *
 * @author Nolan Peterson
 * @version 7/07/22
 */
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class goltry2
{

    static final int WIDTH = 22; // Grid width is 22, but I will only be showing 20
    static final int HEIGHT = 22; // Height = 22
    static int [][]cells;
    static String deadCell; // Setting what a dead cell looks like
    static  String aliveCell;// Setting what a dead cell looks like
    static int [][]future; // next grid
    static boolean auto = false; // Automatically printing
    static int cellsSave[][];
    static String chooseMode; // Choosemode
    static int autoDuration = 1; // How long it has been automatically playing

    public static void main(String[] args) { 
        String command; // While quit is false, we will be overwriting this string loads
        boolean quit = false; // Looking for a 'command'
        int turnNumber = 1; // Amount of turns is 1
        int row = 0; // For manual selection
        int column = 0;
        // How long  it has been auto
        int autoNum = 0; // How many times has it will print
        cells = new int [WIDTH][HEIGHT]; 
        cellsSave = new int [WIDTH][HEIGHT];
        // Keyboard Scanner
        Scanner keyboard = new Scanner(System.in);

        // Setting the visual indicators for dead and alive
        System.out.println("What would you like the dead cells to look like?");
        deadCell =keyboard.nextLine();
        System.out.println("What would you like the alive cells to look like?");
        aliveCell =keyboard.nextLine();

        // random function
        Random r = new Random();
        boolean chosenMode = false;
        // Determines which cells are alive or dead on generation
        System.out.println("Would you like cells to be automatically generated or manually?");
        while (chosenMode ==false){ // The loop allows you to input something wrong, and have it loop back so you don't crash 
            chooseMode=keyboard.nextLine();
            chooseMode=chooseMode.toLowerCase();

            switch(chooseMode){ // Choosing auto or manual generation
                case "auto": case"1": case "automatic":
                chosenMode=true;
                System.out.println("You have chosen automatic");
                System.out.println("How likely would you like the cells to be alive on generation? (e.g. 5 for a 5% chance)");

                int aliveProbability = keyboard.nextInt(); // chance of cells being alive when created
                for (int x=1; x<WIDTH-1; x++){
                    for (int y=1; y<HEIGHT-1; y++) { // Creating phantom cells that aren't printed to prevent crashes
                        int state = r.nextInt(100)+1; // State = a random number 1-100
                        if (state > aliveProbability){ // If state is greater than alive probability, die
                            state = 0; // dead
                        }
                        else {
                            state = 1; // alive
                        }

                        cells[x][y] = state; // print dead/alive cells
                        if (cells[x][y] == 0)
                            cellsSave[x][y]=0;
                        System.out.print(deadCell+ " "); 
                        if (cells[x][y] == 1)
                            System.out.print(aliveCell+ " ");
                        cellsSave[x][y]=1;
                    }

                    System.out.println();

                }

                System.out.println();
                break; 

                case "manual": case "2": case "manually":case"man":
                chosenMode=true;
                System.out.println("You have chosen manual. When you have finished, type 'Next' to continue");
                boolean manualPlaying = true;
                while (manualPlaying){

                    System.out.println("Select the column of a cell you would like to turn on");

                    if(keyboard.hasNextInt()){ // If there is an int, it means they want to change column/row. If not, they probably want to continue.
                        column=keyboard.nextInt();
                    }
                    else {

                        chooseMode=keyboard.nextLine();
                        manualPlaying = false;
                        break;
                    }
                    System.out.println("Select the row of a cell you would like to turn on");
                    if(keyboard.hasNextInt()){
                        row=keyboard.nextInt();
                    }
                    else {

                        chooseMode=keyboard.nextLine();
                        manualPlaying = false;
                        break;
                    }
                    for (int x=1; x<WIDTH-1; x++){ // print da griddy
                        for (int y=1; y<HEIGHT-1; y++) {

                            cells[row][column]=1;

                            if (cells[x][y] == 0)
                                cellsSave[x][y]=0;
                            System.out.print(deadCell+ " "); 
                            if (cells[x][y] == 1)
                                System.out.print(aliveCell+ " ");
                            cellsSave[x][y]=1;
                        }

                        System.out.println();

                    }
                }
                break;
                default:
                System.out.println("Invalid Command, Choose Manual or Auto.");

                break;
            }
        }
        // User interaction switch statement

        while (!quit){ // While the user has not quit, always look for a command
            command=keyboard.nextLine();
            command=command.toLowerCase(); // Converts input into lowercase, meaning commands are not case sensitive
            switch(command){
                // If the command is automatic, ask for how many turns to advance
                case "auto":  auto = true;
                System.out.println("How many turns would you like it to be automatic for?");
                autoNum = keyboard.nextInt(); // how many grids to auto print
                while (auto == true){ //While auto is true, and autoduration is less than autonum, print grids at a 250ms interval

                    try {
                        Thread.sleep(250); // wait 250ms per generation - prevents lag
                        System.out.println("Turn #"+turnNumber);

                        nextGen();
                        turnNumber++;
                        autoDuration++;

                    } catch (Exception e) {

                    }
                    if (autoDuration > autoNum) { // if it's been going too long, change auto to false, and autoduration to 1
                        auto=false;
                        autoDuration=1;
                    } 

                }
                break;
                case "next": // Advances 1 turn
                System.out.println("Turn #"+turnNumber);
                turnNumber++;
                nextGen();
                break;
                case "quit": quit = true; // Stops asking for keyboard input
                break;
                case "":
                System.out.println("Type 'Next' to advance");// When you get in, the 'case' will automatically be nothing, but for some reason this was prompting the default case so I set a special one.
                break;
                default: 
                System.out.println("Invalid Command");
                break;

            }
        } keyboard.close();
    }

    public static void nextGen(){
        future= new int [WIDTH][HEIGHT];

        for (int x=1; x<WIDTH-1; x++){
            for (int y=1; y<HEIGHT-1; y++) {// Creating phantom cells that aren't printed to prevent crashes
                int neighbours=0;

                //*** Neighbour check and bump. Should be tidied up

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
                        future[x][y] = 0;
                    }
                }

                if (cells[x][y]==1 && neighbours ==2 ){
                    future[x][y]=1;
                }

                if (cells[x][y]==0 && neighbours == 2){
                    future[x][y]=0;
                }

                if (neighbours == 3) { // If a cell has 3 neighbours, become a live cell.
                    future[x][y] =1;
                }
                // If not, remain the same

                // Print grid
                if (future[x][y] == 0){

                    System.out.print(deadCell+" ");
                }
                if (future[x][y] == 1){

                    System.out.print(aliveCell+ " ");
                }

            }

            System.out.println();

        }
        // for (int x=1; x<WIDTH-1; x++){
        // for (int y=1; y<HEIGHT-1; y++){

        // if (Arrays.deepEquals(cells[x][y],future[x][y]))
        // System.out.println("Game has reached a steady state");
        // auto=false;
        // autoDuration=1;
        // }

        // }
        //int cellsSave[][] = new int [WIDTH][HEIGHT];
        for (int x=1; x<WIDTH-1; x++){
                        for (int y=1; y<HEIGHT-1; y++){

                            if (future[x][y]==1) {
                                cells[x][y]=1;
                            }
                            else{
                                cells[x][y]=0;
                            }
                        }
                    }
        for(int i = 0; i < cells.length; i++){
            for(int j = 1; j < future[i].length; j++){
                if(cells[i][0]==(future[i][j])){
                    auto=false;
                    autoDuration=1;
                    
                }
            }
        }

    }
}
