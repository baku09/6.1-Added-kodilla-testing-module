package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> elements;

    public SudokuRow() {
        elements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            elements.add(new SudokuElement());
        }
    }
    public SudokuElement getElement(int index) {
        return elements.get(index);
    }
    public void setElementValue(int index, int value) {
        elements.get(index).setValue(value);
    }
    public void removePossibleValue(int columnIndex, int value) {
        for (SudokuElement element : elements) {
            element.removePossibleValue(value);
        }
    }
}
