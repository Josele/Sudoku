package com.joselemg.sudokupkg;

/**
 * Created by Josele on 25/03/2017.
 */
public class Cell {
    private final int x;
    private final int y;
    private Value value;
    private final boolean fix;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.fix = false;
        value = Value.EMPTY;
    }
    public Cell(int x, int y, Value value, boolean fix) {
        this.x = x;
        this.y = y;
        this.fix = fix;
        this.value = value;
    }
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    public boolean isFix(){
       return fix;
    }
}
