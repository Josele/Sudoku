package com.joselemg.sudokupkg;


import java.util.*;
import java.io.*;

/**
 * Instantiate a sudoku game.
 *
 * @author Josele
 * @version 23.03.2017
 */
public class SudokuGame  {
    private final int n=9;

    private static Sudoku instance = null;

    public SudokuGame() {
//        this.instance = new Sudoku();
    }

    /**
     * @param filename
     */
    public SudokuGame(String filename) throws  Exception{
        Cell[][] arraycells = new Cell[n][n];
        BufferedReader br = null;
        FileReader fr = null;
        int cellvalue;
        int i=0;
        try {

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null && i<=9) {
                sCurrentLine = sCurrentLine.trim();
                System.out.println(sCurrentLine);
                int len = sCurrentLine.length();
                if(len<=9){
                    throw new Exception("Impossible to generate the sudoku. Please check the input file.");
                }
                for (int j = 0; j < len; j++) {
                    if (Character.isDigit(sCurrentLine.charAt(j))) {
                        cellvalue = Character.getNumericValue(sCurrentLine.charAt(j));

                        arraycells[i][j]=  new Cell(i, j, Value.fromInteger(cellvalue),true);
                    } else if (sCurrentLine.charAt(i) == ';') {
                        arraycells[i][j]=  new Cell(i, j);                    }
                }
              i++;
            }

        } catch (IOException e) {

//            e.printStackTrace();

            System.err.println("Input file error: The input file must be in the same folder than the program");
        }catch (Exception e) {

            e.printStackTrace();
        }
        instance = new Sudoku(arraycells,n);

        }
}
