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
     * Constructor:  N xN Matrix of cells.
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

    public Sudoku(Cell[][] cells, int n) {
        this.n = n;
        this.cells = cells;
        this.stateGame = StateGame.STARTED;
    }
}
