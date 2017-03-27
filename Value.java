package com.joselemg.sudokupkg;

/**
 * @author Josele
 * @version 25.03.2017
 *
 * Enumeration of the possible values for a cell.
 */
public enum Value {
    EMPTY,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE;

    /**
     * fromInteger: Convert a number into a Value enum.
     *
     * @param x Integer from 0 to 9. Otherwise will return null.
     * @return Value enum.
     */
    public static Value fromInteger(int x) {
        switch(x) {
            case 0:
                return EMPTY;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
        }
        return null;
    }

    /**
     * toInteger: Convert a Value type into an integer.
     *
     * @param x Value enum.
     * @return Integer.
     */
    public static int toInteger(Value x) {
        switch(x) {
            case EMPTY:
                return 0;
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
        }
        return -1;
    }
}
