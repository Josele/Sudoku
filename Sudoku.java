
/**
 * @author Josele
 * @version 27.03.2017
 *
 *          Description: A sudoku object which contains an array of cells as board game, the state of the game and the size of the board.
 *          The default value of the size is nine.
 */

public class Sudoku {
    private Cell[][] cells = null;
    private StateGame stateGame = null;
    private int n = 9;

    /**
     * Constructor:  Create an empty sudoku.
     *
     * @param n size of the sudoku.
     */
    public Sudoku(int n) {
        this.n = n;
        this.cells = new Cell[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
        this.stateGame = StateGame.STARTED;
    }

    /**
     * Constructor:  Create a sudoku from an array of cells.
     *
     * @param cells Game board.
     * @param n     Sized of the sudoku.
     */
    public Sudoku(Cell[][] cells, int n) {
        this.n = n;
        this.cells = cells;
        this.stateGame = StateGame.STARTED;
    }

    /**
     * printSudoku: Print the state of the sudoku through the system output.
     */
    public void printSudoku() {
        for (int x = 0; x < n; x++) {
            if (x % 3 == 0) {
                for (int k = 0; k < 12; k++) {
                    System.out.print("-");
                }

                System.out.println("");
            }
            for (int y = 0; y < n; y++) {
                if (y % 3 == 0)
                    System.out.print("|");
                System.out.print(Value.toInteger(cells[x][y].getValue()));
            }
            System.out.println("|");

        }

    }

    /**
     * setStateGame: Set the state of the game.
     *
     * @param stateGame StateGame enum.
     */
    public void setStateGame(StateGame stateGame) {
        this.stateGame = stateGame;
    }

    /**
     * getStateGame: Getter.
     *
     * @return StateGame enum.
     */
    public StateGame getStateGame() {
        return stateGame;
    }

    /**
     * playValue: Try to plays a value in a cell. Will return "true" if he was able to do it.
     *
     * @param x   Row value.
     * @param y   Column value.
     * @param val Value enum.
     * @return boolean.
     */
    public boolean playValue(int x, int y, Value val) {
        if (this.rowColumnChecker(x, y, val) && this.blockChecker(x, y, val))
            return cells[x][y].setValue(val);
        return false;
    }

    /**
     * cleanValue: Cleans the value of a cell defined with x and y. Fix clean can not be cleaned. Returns "true" if it succeed.
     *
     * @param x Row value.
     * @param y Column value.
     * @return boolean.
     */
    public boolean cleanValue(int x, int y) {
        return cells[x][y].setValue(Value.EMPTY);
    }

    /**
     * rowColumnChecker: check if a value can be set in a cell, respect the constraints (rules) of rows and columns in a sudoku.
     * Will return "true" if the value can be set in that cell with respect of the constraints, otherwise "false".
     *
     * @param x   Row value.
     * @param y   Column value.
     * @param val Value enum.
     * @return boolean.
     */
    private boolean rowColumnChecker(int x, int y, Value val) {

        for (int i = 0; i < n; i++) {
            if ((y != i && val == cells[x][i].getValue()) || (x != i && val == cells[i][y].getValue()))
                return false;
        }
        return true;
    }

    /**
     * blockChecker: check if a value can be set in a cell, respect the constraints (rules) of blocks 3x3 in a sudoku.
     * Will return "true" if the value can be set in that cell with respect of the constraints, otherwise "false".
     *
     * @param x   Row value.
     * @param y   Column value.
     * @param val Value enum.
     * @return boolean.
     */
    private boolean blockChecker(int x, int y, Value val) {

        int xSector  = ((int) Math.ceil(x / 3)) * 3;
        int ySector = ((int) Math.ceil(y / 3)) * 3;
        for (int i = xSector; i < xSector + 3; i++) {
            for (int j = ySector; j < ySector + 3; j++)
                if ((!(x == i && y == i)) && val == cells[i][j].getValue())
                    return false;
        }
        return true;
    }

    /**
     * isFix: Tell if the xy cell has a permanent value.
     *
     * @param x Row value.
     * @param y Column value.
     * @return boolean.
     */
    public boolean isFix(int x, int y) {
        return cells[x][y].isFix();
    }

}
