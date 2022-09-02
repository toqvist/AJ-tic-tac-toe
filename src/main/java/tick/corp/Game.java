package tick.corp;

public class Game {

    private char[][] grid;

    private String mode;
    private int winningNumber;
    private int size;

    private boolean running = true;
    private char activePlayer = 'X';
    private char winner = ' ';

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

                int middle = xMax / 2;

                // Put in blockers
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

    private void setWinner(char player) {
        winner = player;
    }

    private void checkWinner() {

        // Check rows
        for (int y = 0; y < grid.length; y++) {
            int xRows = 0;
            int oRows = 0;

            for (int x = 0; x < grid[y].length; x++) {

                if (grid[y][x] == 'X') {
                    xRows++;
                }

                if (grid[y][x] == 'O') {
                    oRows++;
                }

            }
            if (xRows >= winningNumber) {
                setWinner('X');
            }

            if (oRows >= winningNumber) {
                setWinner('O');
            }
        }

        // //Check columns
        for (int x = 0; x < grid[0].length; x++) {
            int xCols = 0;
            int oCols = 0;

            for (int y = 0; y < grid.length; y++) {

                if (grid[y][x] == 'X') {
                    xCols++;
                }

                if (grid[y][x] == 'O') {
                    oCols++;
                }

            }
            if (xCols >= winningNumber) {
                setWinner('X');
            }

            if (oCols >= winningNumber) {
                setWinner('O');
            }
        }

        int xDiag = 0;
        int xCDiag = 0;
        int oDiag = 0;
        int oCDiag = 0;

        // Check diagonally and counter-diagonally
        if (mode == "pyramid") {
            // Diag
            int middle = grid[0].length / 2;
          
            for (int i = 0; i < size; i++) {

                // Diagonally
                if (grid[i][middle + i] == 'X') {
                    xDiag++;
                }

                if (grid[i][middle + i] == 'O') {
                    oDiag++;
                }

                // Counter-diagonally
                if (grid[i][middle - i] == 'X') {
                    xCDiag++;
                }

                if (grid[i][middle - i] == 'O') {
                    oCDiag++;
                }

            }
        } else {
        
            for (int i = 0; i < size; i++) {
                
                // Diagonally
                 if (grid[i][i] == 'X') {
                     xDiag++;
                 }
 

                 if (grid[i][i] == 'O') {
                    oDiag++;
                }

                // Counter-diagonally
                 if (grid[size - 1][size - 1 - i] == 'X') {
                     xCDiag++;
                 }
 
                 if (grid[size - 11][size - 1 - i] == 'O') {
                     oCDiag++;
                 }
             }
        }
        if (xDiag >= winningNumber || xCDiag >= winningNumber) {
            setWinner('X');
        }

        if (oDiag >= winningNumber || oCDiag >= winningNumber) {
            setWinner('O');
        }

    }

    public char[][] getGrid() {
        return this.grid;
    }

    public boolean getRunning() {
        return this.running;
    }

    public char getWinner() {
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
