package com.joselemg.sudokupkg;

public class Main {

    public static void main(String[] args) throws Exception {
        SudokuGame oneGame;
        if(args.length==0)
        {
            oneGame = new SudokuGame("inputfile.txt");
        }
        else
            oneGame =new SudokuGame(args[0]);
        System.out.println("Entered sudoku:");
        oneGame.printStateGame();
        oneGame.solve();
        System.out.println("Output sudoku:");
        oneGame.printStateGame();

    }
}
