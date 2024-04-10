package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private ArrayList<Integer> possibleValues;

    public SudokuElement() {
        value = EMPTY;
        possibleValues = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        possibleValues.clear();
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void removePossibleValue(int value) {
        possibleValues.remove(Integer.valueOf(value));
    }
}
