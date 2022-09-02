package tick.corp;

public class Game {

    private char[][] grid;

    private String mode;
    private int winningNumber;
    private int size;

    /**
     * @param mode
     */
    public Game(String mode, int size) {

        this.mode = mode;
        this.size = size;

        switch (mode) {
            case "classic":
                winningNumber = size;

                this.grid = new char[size][];

                for (int y = 0; y < size; y++) {

                    this.grid[y] = new char[size];

                    for (int x = 0; x < grid[y].length; x++) {
                        this.grid[y][x] = '0';
                    }

                }
                break;

            case "pyramid":
                winningNumber = size;

                this.grid = new char[size][];
                this.grid[0] = new char[] { ' ' };

                for (int y = 1; y < size; y++) {

                    this.grid[y] = new char[size + 2];

                    for (int x = 0; x < grid[y].length; x++) {
                        this.grid[y][x] = ' ';
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


    public char[][] getGrid() {
        return this.grid;
    }

}
