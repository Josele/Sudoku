package com.joselemg.sudokupkg;

/**
 * @author Josele
 * @version 25.03.2017
 *
 * Description: Cell object which contains one value ( empty, one, ..., nine), two integers that indicate a position in 2D plane and
 * an attribute fix which indicate if the value can be changed.
 */
public class Cell {
    private final int x;
    private final int y;
    private Value value;
    private final boolean fix;

    /**
     * Constructor: Creates an empty cell, without a fix value.
     *
     * @param x Row value.
     * @param y Column value.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.fix = false;
        value = Value.EMPTY;
    }

    /**
     * Constructor: Creates a cell with a value. It can be a fix value
     *
     * @param x Row value.
     * @param y Column value.
     * @param value Value enum
     * @param fix We declare if the value is fix.
     */
    public Cell(int x, int y, Value value, boolean fix) {
        this.x = x;
        this.y = y;
        this.fix = fix;
        this.value = value;
    }

    /**
     * getValue: Getter of the value of a cell.
     *
     * @return value enum
     */
    public Value getValue() {
        return value;
    }

    /**
     * getX: Getter of the row value of the cell.
     *
     * @return Integer.
     */
    public int getX() {
        return x;
    }

    /**
     * getY: Getter of the column value of the cell.
     *
     * @return Integer.
     */
    public int getY() {
        return y;
    }

    /**
     * setVelue: Try to set a value in the cell. Return true if it succeed.
     *
     * @param value Value enum.
     * @return boolean.
     */
    public boolean setValue(Value value) {
        if(!fix)
            this.value = value;
        return !fix;
    }

    /**
     * isFix: Tell if the cell has a permanent value.
     *
     * @return boolean
     */
    public boolean isFix(){
       return fix;
    }

}
