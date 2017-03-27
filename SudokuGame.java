package com.joselemg.sudokupkg;


import java.io.*;

/**
 * @author Josele
 * @version 23.03.2017
 *
 * Description: Instantiate a sudoku game. Here we could play with the sudoku or call the solver.
 */
public class SudokuGame {
    private final int n = 9;
    private Sudoku instance = null;

    /**
     * Constructor:  Create a sudokuGame.
     *
     * @param filename
     * @throws Exception
     */
    public SudokuGame(String filename) throws Exception {
        Cell[][] arraycells = new Cell[n][n];
        BufferedReader br = null;
        FileReader fr = null;
        int cellvalue;
        int x = 0;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null && x < 9) {
                int y = 0;
                sCurrentLine = sCurrentLine.trim();
                System.out.println(sCurrentLine);
                int len = sCurrentLine.length();
                if (len < 9) {
                    throw new Exception("Impossible to generate the sudoku. Please check the input file.");
                }
                for (int j = 0; ((j < len) && y < 9); j++) {
                    if (Character.isDigit(sCurrentLine.charAt(j))) {
                        cellvalue = Character.getNumericValue(sCurrentLine.charAt(j));
                        arraycells[x][y] = new Cell(x, y, Value.fromInteger(cellvalue), true);
                        y++;
                    } else if (sCurrentLine.charAt(j) == ';') {
                        arraycells[x][y] = new Cell(x, y);
                        y++;
                    }
                }
                x++;
            }

        } catch (IOException e) {

//            e.printStackTrace();

            System.err.println("Input file error: The input file must be in the same folder than the program");
        }
        instance = new Sudoku(arraycells, n);

    }

    /**
     * solve: Solves the sudoku of the Sudokugame by calling the sudoku solver.
     */
    public void solve() {


        if (this.solver(0, 0)) {
            instance.setStateGame(StateGame.FINISHED);
            System.out.println("The sudoku has been solved.");

        } else {
            instance.setStateGame(StateGame.STUCK);

            System.out.println("There is no solution for this sudoku.");
        }
    }

    /**
     * solver: Recursive algorithm which solves sudokus. Try to find a value for a cell of the sudoku and then call himself for the next cell.
     * Should be call from solve().
     *
     * @param x Row value of the current cell.
     * @param y Column value of the current cell.
     * @return boolean
     */
    public boolean solver(int x, int y) {

        if ((x == n - 1) && x == y) {       // Ending of the recursive algorithm. X==Y, last values.
            if (instance.isFix(x, y))       // If the cell has a fix value, we finished.
                return true;
            for (int i = 1; i <= n; i++) {  // If the cell hasn't a fix value, we try to find a value that match for that cell but we won't call solver() again.
                if (instance.playValue(x, y, Value.fromInteger(i)))
                    return true;
            }

        } else {                            // For the rest of the cases, we try numbers and call solver() again.
            if (instance.isFix(x, y)) {     // If the cell has a fix value we will return true, but before doing that we call solver
                if (this.solver((y == 8) ? x + 1 : x, (y == 8) ? 0 : y + 1))         // We call solver() for the next cell and check if we are in the left side y==8.
                    return true;
            } else
                for (int i = 1; i <= n; i++) {                       // We try to find a value that match for that cell and we will call solver() again.
                    if (instance.playValue(x, y, Value.fromInteger(i))) {
                        if (this.solver((y == 8) ? x + 1 : x, (y == 8) ? 0 : y + 1)) // We call solver() for the next cell and check if we are in the left side y==8.
                            return true;
                    }
                }

        }
        instance.cleanValue(x, y);
        return false;
    }

    /**
     * printStateGame: Tells the state of the sudoku and call printSudoku().
     */
    public void printStateGame() {
        System.out.print("The state of the game is ");
        System.out.println(instance.getStateGame());
        instance.printSudoku();
    }
}
