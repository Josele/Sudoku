package com.joselemg.sudokupkg;

/**
 * Created by Josele on 25/03/2017.
 */
public enum Value {
    EMPTY,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE;
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
