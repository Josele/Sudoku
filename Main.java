package com.joselemg.sudokupkg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        SudokuGame oneGame;
        if(args.length==0)
        {
            oneGame = new SudokuGame("inputfile.txt");
        }
        else
            oneGame =new SudokuGame(args[0]);

        oneGame.printStateGame();
        oneGame.solve();
        oneGame.printStateGame();

    }
}
