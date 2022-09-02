package tick.corp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        int boardSize = 3;
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
                case 1: // Classic
                    playGame("classic", boardSize);
                    break;
                case 2:
                    playGame("pyramid", boardSize);
                    break;
                case 3:
                    System.out.print("Enter new board size: ");
                    int newSize = scan.nextInt();
                    if (newSize > 16) {
                        System.out.println("Board can be 16 cells maximum");
                    } else if (newSize < 3) {
                        System.out.println("Board must be at least 3 cells big");
                    } else {
                        System.out.println("New board size set to " + newSize);
                        boardSize = newSize;

                    }

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

            if (select1.equals("quit")) {
                game.quit();
                break;
            }
            System.out.println("Enter X: ");
            String select2 = scan.next();

            if (select1.equals("quit") || select2.equals("quit")) {
                game.quit();
                break;
            }

            // Select returns true if selection successfull
            if (game.select(select1, select2)) {

                printBoard(game);

                if (game.getWinner() != ' ') {

                    System.out.println(game.getWinner() + "'s' win!");

                    System.out.println("Enter any character to continue.");
                    scan.next();
                    game.quit();
                }
            } else {
                System.out.println("Please make a valid selection");

            }

            if (game.isStalemate()) {
                System.out.println("Stalemate!");
                System.out.println("Enter any character to continue.");
                scan.next();
                game.quit();
            }

        }

    }

    private static void printMenu() {
        System.out.println("Welcome to the tic-tac-toe zone!");
        System.out.println("[0] - Exit game");
        System.out.println("[1] - Play classic mode");
        System.out.println("[2] - Play pyramid mode");
        System.out.println("[3] - Change board size");
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

        // Print divider
        System.out.print("   ");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print("————");
        }

        System.out.println();

        // Print grid with lines and values
        for (int y = 0; y < grid.length; y++) {

            System.out.print(y);

            // Left border
            System.out.print(" | ");

            // Cells
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print(grid[y][x] + " | ");
            }
            System.out.println();
            System.out.print("   ");

            for (int i = 0; i < grid[y].length; i++) {

                System.out.print("————");
            }

            System.out.println();
        }

    }

}
