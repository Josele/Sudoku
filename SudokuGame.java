package com.joselemg.sudokupkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Instantiate a sudoku game.
 *
 * @author Josele
 * @version 23.03.2017
 */
public class SudokuGame {


    private static Sudoku instance = null;

    public SudokuGame() {
        this.instance = new Sudoku();
    }

    /**
     * @param filename
     */
    public SudokuGame(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        try {

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
