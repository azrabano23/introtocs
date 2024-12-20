/**
 * Play Minesweeper.
 * Methods to complete:
 * placeMines(), fillGrid(), openSquare(), placeFlag(), 
 * checkWinCondition(), chooseDifficulty(), playRandom()
 * 
 * @author Jessica de Brito
 * @author Jeremy Hui
 */

public class PlayMinesweeper {
    private Square[][] grid;
    private int flagCount;   // the number of mines in the grid
    private int totalMines;   // the number of mines in the grid

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * Default constructor.
     * Initializes a 0x0 game grid with 0 flags.
     */
    public PlayMinesweeper() {
        this(new Square[0][0], 0);
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * Overloaded constructor: initalizes a Play Minesweeper object
     * based on a given 2D array of squares and the number of flags.
     * @param grid the 2D array of squares
     * @param totalMines the number of mines in the grid
     */
    public PlayMinesweeper(Square[][] grid, int totalMines) {
        StdRandom.setSeed(2024);
        this.grid = grid;
        this.flagCount = 0;
        this.totalMines = totalMines;
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * Returns the 2D array of squares.
     * @return the 2D array of squares
     */
    public Square[][] getGrid() {
        return grid;
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * REturns the flag count.
     * @return the flag count
     */
    public int getFlagCount() {
        return flagCount;
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * Returns the mines count.
     * @return the mines count
     */
    public int getMinesCount() {
        return totalMines;
    }

    /**
     * This method takes in an input file and sets the 2D array of squares and
     * flag count according to the specification of the file.
     * The first two integers m and n represent a 2D array of squares with
     * m rows and n columns.
     * Each following line represents a mine to be placed in the 2D array of
     * squares, with the first integer representing the row number, and the
     * second integer representing the column number.
     * 
     * A square with a mine will be represented with a -1 Square number,
     * otherwise the Square number will be left at its default value of 0.
     * All Squares will be left at its default state of being CLOSED.
     * 
     * If the square is a mine, increment totalMines.
     * 
     * @param inputFile the given input file
     * NOTE: All square objects in the 2D array of squares will be initialized.
     */
    public void placeMines(String inputFile) {
        StdIn.setFile(inputFile); // DO NOT REMOVE OR EDIT THIS LINE
        int rows = StdIn.readInt();
        int cols = StdIn.readInt();
    
        grid = new Square[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Square();
            }
        }
    
        totalMines = 0;
        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();
            StdIn.readLine(); // Move to the next line
            grid[row][col].setSqNum(-1); // Mark as mine
            totalMines++;
        }
    }
    

    /**
     * This method sets the square number of each square in the 2D array
     * of squares array without a mine to equal the number of adjacent mines 
     * in all 8 directions (up, down, left, right, and diagonally).
     * Squares without no adjacent mines will be left at a square number
     * of 0.
     */
    public void fillGrid() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].getSqNum() == -1) continue;
    
                int mineCount = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length &&
                        grid[ni][nj].getSqNum() == -1) {
                        mineCount++;
                    }
                }
                grid[i][j].setSqNum(mineCount);
            }
        }
    }
    

    /**
     * This method sets the selected square to be OPEN.
     * If the original state of the square is flagged,
     * remove the flag, don't forget to decrement flagCount.
     * 
     * Additionally, if the square number of the selected square
     * is 0, this method also opens all adjacent squares in all 8
     * directions (up, down, left, right, and diagonally) by
     * setting its square state to be OPEN.
     * 
     * This method returns true if the square selected did not have
     * a mine, and false otherwise.
     * 
     * @param row the given row
     * @param col the given column
     * @return true if the square selected did not have a mine, false otherwise
     */
    public boolean openSquare(int row, int col) {
        if (grid[row][col].getSqState() == State.FLAGGED) {
            grid[row][col].setSqState(State.CLOSED);
            flagCount--;
        }
    
        if (grid[row][col].getSqNum() == -1) {
            return false; // Mine clicked
        }
    
        if (grid[row][col].getSqState() == State.OPEN) {
            return true; // Already open
        }
    
        grid[row][col].setSqState(State.OPEN);
    
        if (grid[row][col].getSqNum() == 0) {
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
            for (int k = 0; k < 8; k++) {
                int ni = row + dx[k];
                int nj = col + dy[k];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length &&
                    grid[ni][nj].getSqState() != State.OPEN) {
                    openSquare(ni, nj);
                }
            }
        }
    
        return true;
    }
    

    /**
     * This method sets the state of square at a given row and column
     * depending on its current state.
     *
     * If the square is FLAGGED, set the state of the square to be CLOSED
     * to represent removing a flag.
     * 
     * If the square is CLOSED, set the state of the square to be FLAGGED
     * to represent placing a flag.
     * 
     * The flag count must be incremented if a flag is placed
     * and decremented if a flag is removed.
     * 
     * @param row the given row
     * @param col the given column
     */
    public void placeFlag(int row, int col) {
        if (grid[row][col].getSqState() == State.OPEN) {
            return; // Cannot flag an open square
        }
    
        if (grid[row][col].getSqState() == State.FLAGGED) {
            grid[row][col].setSqState(State.CLOSED);
            flagCount--;
        } else if (grid[row][col].getSqState() == State.CLOSED) {
            grid[row][col].setSqState(State.FLAGGED);
            flagCount++;
        }
    }
    

    /**
     * This method returns false if there still exists a square in the 
     * 2D array of squares that is not a mine that does not have an 
     * OPEN state, and true otherwise.
     * @return false if the win condition has not been met, true otherwise
     */
    public boolean checkWinCondition() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].getSqNum() != -1 && grid[i][j].getSqState() != State.OPEN) {
                    return false; // Unopened safe square found
                }
            }
        }
        return true;
    }
    

    /**
     * This method sets the dimension of the 2D array of squares
     * and the total mines based on the given difficulty:
     *  - an 8x8 grid and a total mines of 10 on a "Beginner" level,
     *  - a 16x16 grid and a total mines of 40 on an "Intermediate" level,
     *  - and a 30x16 grid and a total mines of 99 on an "Advanced" level. 
     * 
     * @param level the given difficulty level
     * NOTE: All square objects in the 2D array of squares will be initialized.
     */
    public void chooseDifficulty(String level) {
        if (level.equals("Beginner")) {
            grid = new Square[8][8];
            totalMines = 10;
        } else if (level.equals("Intermediate")) {
            grid = new Square[16][16];
            totalMines = 40;
        } else if (level.equals("Advanced")) {
            grid = new Square[30][16];
            totalMines = 99;
        }
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Square();
            }
        }
    }
    

    /**
     * This method places mines in the 2D array of squares according
     * to the specifications of the following algorithm:
     *
     * 1. Use StdRandom.uniform() twice, the first of which will
     * be a random row number and the second of which will be a 
     * random row column to place a mine.
     *
     * 2. If the randomly generated row and column numbers already
     * are the position of the first click (given by the input 
     * parameters row and col), generate a new row and column number
     * and repeat this step. Otherwise place a mine at the given
     * row and column.
     *
     * 3. Repeat this process until the grid contains n mines, 
     * where n = 10 for "Beginner" difficulty,
     * n = 40 for "Intermediate" difficulty, and n = 99 for
     * "Advanced" difficulty given by the level input parameter.
     *
     * @param level the given difficulty level
     * @param row the given row of the fist click
     * @param col the given column of the first click
     */
    public void playRandom(String level, int row, int col) {
        int minesToPlace = 0;
    
        if (level.equals("Beginner")) {
            minesToPlace = 10;
        } else if (level.equals("Intermediate")) {
            minesToPlace = 40;
        } else if (level.equals("Advanced")) {
            minesToPlace = 99;
        }
    
        while (minesToPlace > 0) {
            int randomRow = StdRandom.uniform(grid.length);
            int randomCol = StdRandom.uniform(grid[0].length);
    
            if ((randomRow != row || randomCol != col) && grid[randomRow][randomCol].getSqNum() != -1) {
                grid[randomRow][randomCol].setSqNum(-1);
                minesToPlace--;
            }
        }
    }
    

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * This method prints all square numbers in 
     * the 2D array of squares, regardless of its current state.
     * Called when testing individual methods in the TextDriver.
     */
    public void printGridNums() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                StdOut.print(grid[i][j].getSqNum() + "\t");
            StdOut.println();
        }
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * This method sets all squares to the OPEN state.
     * Called when testing individual methods in the Driver.
     */
    public void openAllSquares() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j].setSqState(State.OPEN);
            }
        }   
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS METHOD
     * This method sets all squares to the CLOSED state.
     * Called when testing individual methods in the Driver.
     */
    public void closeAllSquares() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j].setSqState(State.CLOSED);
            }
        }   
    }
}
