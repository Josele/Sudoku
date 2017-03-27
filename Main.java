package com.joselemg.sudokupkg;

/**
 * @author Josele
 * @version 27.03.2017
 */
public class Main {


    public static void main(String[] args) throws Exception {
        SudokuGame oneGame;
        try {
            if (args.length == 0) {
                System.out.println("Missing input file.");
            } else {
                oneGame = new SudokuGame(args[0]);
                System.out.println("Entered sudoku:");
                oneGame.printStateGame();
                oneGame.solve();
                System.out.println("Output sudoku:");
                oneGame.printStateGame();
            }
        } catch (RuntimeException e) {
            System.err.println(e);
        }
    }
}
