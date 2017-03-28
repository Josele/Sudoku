# Sudoku
Class SudokuGames that allows users to create sudokus and find a solution for them.

SudokuSolver contains a "main" function that create a sudoku from an "inputfile.txt" and calls a method, which solve it.

## Hierarchy
- SudokuGame: This class contains a sudoku game and can also solve it.
 - Sudoku: This class is a sudoku. It contains an array of cells that act as the game board.
  - Cell: This class act as a cell of a sudoku. It contains a value type enum, from One to Nine or Empty.
## Running the application from the Command Line/ Terminal:
Create the .class files running the java compiler. At the same folder where the .java files are, run:
### Winodws
```
< PATH to Java>\bin\javac.exe *.java 
```
### Ubuntu

```
< PATH to Java>\bin\javac *.java 
```
After compiling the files, you can execute the SudokuSolver class by running (in the same directory):

```
java SudokuSolver inputfile.txt
```
