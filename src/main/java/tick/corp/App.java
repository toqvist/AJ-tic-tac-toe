package tick.corp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        boolean appRunning = true;
        Scanner scan = new Scanner(System.in);

        while (appRunning) {


            printMenu();
            System.out.println("Enter your choice:");
            int input = scan.nextInt();

            switch (input) {
                case 0:
                    appRunning = false;
                    break;
                case 1: //Classic
                    playGame("classic", 3);
                    break;
                case 2:
                    playGame("pyramid",3 );
                break;
            }
            
        }

    }

    private static void playGame(String mode, int size) {
        Game game = new Game(mode, size);
        Scanner scan = new Scanner(System.in);

        printBoard(game);
        while (game.getRunning()) {

            

            System.out.println(game.getActivePlayer() + "'s turn");
            System.out.println("Enter Y: ");
            String select1 = scan.next();
            System.out.println("Enter X: ");
            String select2 = scan.next();

            if (select1 == "quit" || select2 == "quit") {
                game.quit();
                break;
            }

            //Select returns true if selection successfull
            if(game.select(select1, select2)) {
                
                printBoard(game);

                if (game.getWinner() != "") {
                
                    System.out.println(game.getWinner() + "'s' win!");
                    
                    System.out.println("Press any key to continue.");
                    scan.next();
                    game.quit();
                }
            } else {
                System.out.println("Please make a valid selection");
                
            }

        }


    }

    private static void printMenu() {
        System.out.println("Welcome to the tic-tac-toe zone!");
        System.out.println("[0] - Exit game");
        System.out.println("[1] - Play classic mode");
        System.out.println("[2] - Play pyramid mode");
    }

    private static void printBoard(Game game) {

        char[][] grid = game.getGrid();

        int lastRowLength = grid[grid.length - 1].length;

        // Print row numbers
        System.out.print("    ");

        for (int x = 0; x < lastRowLength; x++) {
            System.out.print(x + "   ");
        }

        System.out.println();

        // Spacer for asymmetric grid
        if (lastRowLength != grid[0].length) {
            for (int j = 0; j < lastRowLength - grid[0].length; j++) {
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

            // Spacer if asymmetric grid
            if (lastRowLength != grid[0].length) {
                for (int i = 0; i < lastRowLength - grid[y].length; i++) {
                    System.out.print("  ");
                }
            }

            // Left border
            System.out.print(" | ");

            // Cells
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print(grid[y][x] + " | ");
            }
            System.out.println();
            System.out.print("   ");

            // Spacer for asymmetric grid
            if (lastRowLength != grid[0].length) {
                for (int j = 0; j < lastRowLength - grid[y].length; j++) {
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
