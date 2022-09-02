package tick.corp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        boolean gameRunning = true;

        // while (gameRunning) {

        // Scanner scanner = new Scanner();

        // switch() {

        // }

        // }

        Game gameClassic = new Game("classic", 3);
        Game gamePyramid = new Game("pyramid", 3);

        printBoard(gameClassic);
        printBoard(gamePyramid);
    }

    private void printMenu() {
        System.out.println("Welcome to the tic-tac-toe zone!");
        System.out.println("[0] - Exit game");
        System.out.println("[1] - Play classic mode");
        System.out.println("[2] - Play pyramid mode");
    }

    private static void printBoard(Game game) {

        char[][] grid = game.getGrid();

        int lastRowLength = grid[grid.length - 1].length;
        System.out.println(lastRowLength);

        // If columns are fewer than rows, center the first row
        // if (lastRowLength != grid[0].length)
        
        // Print row numbers
        System.out.print("    ");

        for (int x = 0; x < lastRowLength; x++) {
            System.out.print(x + "   ");
        }

        System.out.println();

        //Spacer for asymmetric grid
        if (lastRowLength != grid[0].length) {
            for(int j=0;j<lastRowLength-grid[0].length ;j++) {
                System.out.print("  ");
            }   
        }
        
        // Print divider
        System.out.print("   ");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print("————");
        }

        System.out.println();

        // Print grid with lines and values
        for (int y = 0; y < grid.length; y++) {

            System.out.print(y);

            //Spacer if asymmetric grid
            if (lastRowLength != grid[0].length) {
                for(int i=0;i<lastRowLength-grid[y].length ;i++) {
                    System.out.print("  ");
                }
            }

            //Left border
            System.out.print(" | ");

            //Cells
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print(grid[y][x] + " | ");
            }
            System.out.println();
            System.out.print("   ");

            //Spacer for asymmetric grid
            if (lastRowLength != grid[0].length) {
                for(int j=0;j<lastRowLength-grid[y].length ;j++) {
                    System.out.print("  ");
                }   
            }

            for (int i = 0; i < grid[y].length; i++) {

                System.out.print("————");
            }

            System.out.println();
        }

    }

}
