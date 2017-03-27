package com.joselemg.sudokupkg;


import java.util.*;
import java.io.*;

/**
 * Instantiate a sudoku game. Here we could play with the sudoku or call the solver.
 *
 * @author Josele
 * @version 23.03.2017
 */
public class SudokuGame {
    private final int n = 9;
    private static int count = 0;
    private static Sudoku instance = null;

    public SudokuGame() {
//        this.instance = new Sudoku();
    }

    /**
     * Constructor:  Create a sudokuGame
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

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

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
//                        System.out.println(sCurrentLine.charAt(j));
                        arraycells[x][y] = new Cell(x, y, Value.fromInteger(cellvalue), true);
                        y++;
                    } else if (sCurrentLine.charAt(j) == ';') {
//                        System.out.println(sCurrentLine.charAt(j));
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
     * solve: solves the sudoku of the Sudokugame by calling the sudoku solver.
     */
    public void solve() {

        System.out.println(this.solver(0, 0));
        if (instance.getStateGame() == StateGame.FINISHED)
            System.out.println("The sudoku has been solved.");
        else
            System.out.println("There is no solution for this sudoku.");
//                }
        System.out.println(count);
//        System.out.println(instance.playValue(3, 8,Value.ONE));
    }

    /**
     * solver: Recursive algorithm which solves sudokus
     *
     * @param x
     * @param y
     * @return
     */
    public boolean solver(int x, int y) {
        count++;
        if ((x == n - 1) && x == y) {       // Ending of the recursive algorithm. X==Y, last values.
            if (instance.isFix(x, y))             // Don't do anything if the call is fix
                return true;
            for (int i = 1; i <= n; i++) {
                if (instance.playValue(x, y, Value.fromInteger(i)))
                    return true;
            }

        } else {                            // Rest of the cases, try numbers.
            if (instance.isFix(x, y)) {            // Don't do anything if the call is fix
//                System.out.println("x:" + x + " y:" + y);
                if (this.solver((y == 8) ? x + 1 : x, (y == 8) ? 0 : y + 1))     // Call solver for the next cell
                    return true;
            } else
                for (int i = 1; i <= n; i++) {
//                    System.out.println("x:"+x+" y:"+y+" "+ Value.fromInteger(i));

//                    if(x==3&&y==8&&Value.fromInteger(i)==Value.ONE)
//                        instance.printSudoku();
                    if (instance.playValue(x, y, Value.fromInteger(i))) {
                        if (this.solver((y == 8) ? x + 1 : x, (y == 8) ? 0 : y + 1))     // Call solver for the next cell
                            return true;
                    }
                }

        }
        instance.cleanValue(x, y, Value.EMPTY);
        return false;
    }

    /**
     * printStateGame: Tells the state of the sudoku and call printSudoku().
     */
    public void printStateGame() {
        System.out.println(instance.getStateGame());
        instance.printSudoku();
    }
}
