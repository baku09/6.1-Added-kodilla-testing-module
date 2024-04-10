package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuBoard {
    private ArrayList<SudokuRow> rows;

    public SudokuBoard() {
        rows = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            rows.add(new SudokuRow());
        }
    }

    public SudokuRow getRow(int index) {
        return rows.get(index);
    }

    public SudokuElement getElement(int rowIndex, int colIndex) {
        return rows.get(rowIndex).getElement(colIndex);
    }

    public void setElementValue(int rowIndex, int colIndex, int value) {
        SudokuRow row = rows.get(rowIndex);
        row.setElementValue(colIndex, value);
        row.removePossibleValue(colIndex, value);
    }

    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(getElement(i, j).getValue() + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("---------+----------+----------");
            }
        }
    }
}
