package com.joselemg.sudokupkg;

/**
 * Instantiate a sudoku.
 *
 * @author Josele
 * @version 23.03.2017
 */

public class Sudoku {
    private static Cell[][] cells = null;
    private StateGame stateGame = null;
    private int n;

    /**
     * Constructor:  Create an empty sudoku
     *
     * @param n
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
     * Constructor:  Create a sudoku from an array of cells
     *
     * @param cells
     * @param n
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
            System.out.println("");

        }

    }


    /**
     * getStateGame: Getter
     *
     * @return a type of StateGame
     */
    public StateGame getStateGame() {
        return stateGame;
    }

    /**
     * playValue: Try to plays a value in a cell. Will return true if he was able to do it.
     *
     * @param x
     * @param y
     * @param val
     * @return
     */
    public boolean playValue(int x,int y, Value val)
    {
        if(this.rowcolumncheker(x,y,val)&&this.blockcheker(x,y,val))
            return cells[x][y].setValue(val);
        return false;

    }

    /**
     * cleanValue:
     *
     * @param x
     * @param y
     * @param val
     * @return
     */
    public boolean cleanValue(int x,int y, Value val)
    {
        return cells[x][y].setValue(val);

    }
    /**
     * rowcolumncheker: check if a value can be set in a cell, respect the constraints (rules) of rows and columns in a sudoku.
     * Will return "true" if the value can be set in that cell with respect of the constraints, otherwise "false".
     * @param x
     * @param y
     * @param val
     * @return boolean
     */
    private boolean rowcolumncheker(int x,int y, Value val) {

        for (int i = 0; i < n; i++) {
            if(x!=i&&val==cells[i][y].getValue())
                return false;
            if(y!=i&&val==cells[x][i].getValue())
                return false;
        }
        return  true;
    }

    /**
     * blockcheker: check if a value can be set in a cell, respect the constraints (rules) of blocks 3x3 in a sudoku.
     * Will return "true" if the value can be set in that cell with respect of the constraints, otherwise "false".
     * @param x
     * @param y
     * @param val
     * @return boolean
     */
    private boolean blockcheker(int x,int y, Value val) {

        int xsector= ((int) Math.ceil(x/3))*3;
        int ysector=((int) Math.ceil(y/3))*3;
        for (int i = xsector; i < xsector+3; i++) {
           for (int j=ysector;j<ysector+3;j++)
            if((!(x==i&&y==i))&&val==cells[i][j].getValue())
                return false;
        }
        return  true;
    }
    public boolean isFix(int x,int y){
        return cells[x][y].isFix();
    }

}
