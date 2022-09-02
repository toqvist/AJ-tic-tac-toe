package tick.corp;

public class Game {

    private char[][] grid;

    private String mode;
    private int winningNumber;
    private int size;

    private boolean running = true;
    private char activePlayer = 'X';
    private String winner = "";

    /**
     * @param mode
     */
    public Game(String mode, int size) {

        this.mode = mode;
        this.size = size;

        switch (mode) {
            case "classic":
                winningNumber = size;

                grid = new char[size][];

                for (int y = 0; y < size; y++) {

                    grid[y] = new char[size];

                    for (int x = 0; x < grid[y].length; x++) {
                        grid[y][x] = ' ';
                    }

                }
                break;

            case "pyramid":
                winningNumber = size;

                grid = new char[size][];
                // grid[0] = new char[] { ' ' };

                int xMax = 0;
                int xIncrement = 2;
                for (int y = 1; y < size; y++) {
                    xMax += xIncrement;
                    xIncrement++;
                }

                // Initialize values
                for (int y = 0; y < size; y++) {
                    grid[y] = new char[xMax];

                    for (int x = 0; x < grid[y].length; x++) {

                        grid[y][x] = ' ';

                    }
                }

                int middle = xMax / 2 ;

                //Put in blockers
                for (int y = 0; y < size; y++) {

                    int lowerBound = middle - y;
                    int higherBound = middle + y;

                    for (int x = 0; x < grid[y].length; x++) {

                        if (x < lowerBound) {
                            grid[y][x] = '#';
                        }

                        if (x > higherBound) {
                            grid[y][x] = '#';
                        }

                    }
                }
                break;
        }

    }

    // public boolean checkAdjecents(int player) {

    // int adjacents = 0;

    // for (int y = 0; y < grid.length; y++) {
    // for (int x = 0; x < grid[y].length; x++) {
    // if(grid[y][x] == grid[y+1][x])
    // }
    // }
    // }

    private void checkWinner() {

    }

    public char[][] getGrid() {
        return this.grid;
    }

    public boolean getRunning() {
        return this.running;
    }

    public String getWinner() {
        return this.winner;
    }

    public char getActivePlayer() {
        return this.activePlayer;
    }

    public void quit() {
        this.running = false;
    }

    public boolean select(String select1, String select2) {

        int s1 = Integer.parseInt(select1);
        int s2 = Integer.parseInt(select2);

        // Check for out of bounds
        if (s1 >= grid[0].length || s1 < 0 ||
            s2 >= grid[0].length || s2 < 0) {
            return false;
        }

        if (grid[s1][s2] == ' ') {

            // Active player is represented by their symbol
            grid[s1][s2] = activePlayer;
            checkWinner();

            if (activePlayer == 'X') {
                activePlayer = 'O';
            } else {
                activePlayer = 'X';
            }

            return true;
        }
        return false;
    }
}
