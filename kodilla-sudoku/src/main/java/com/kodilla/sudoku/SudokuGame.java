package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public boolean resolveSudoku() {
        while (true) {
            board.displayBoard();
            System.out.println("Enter sudoku (row, column, value). Enter SUDOKU to solve");

            String userInput = scanner.nextLine().trim().toUpperCase();

            if (userInput.equals("SUDOKU")) {
                if (solveSudoku()) {
                    board.displayBoard();
                    System.out.println("Sudoku solved!");
                } else {
                    System.out.println("Unable to solve Sudoku with provided values. Try again.");
                }
                break;
            } else {
                try {
                    String[] inputParts = userInput.split(",");
                    int row = Integer.parseInt(inputParts[0]) - 1;
                    int col = Integer.parseInt(inputParts[1]) - 1;
                    int value = Integer.parseInt(inputParts[2]);

                    if (isValidInput(row, col, value)) {
                        board.setElementValue(row, col, value);
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input format. Try again.");
                }
            }
        }

        System.out.println("Do you want to continue? (yes/no)");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

    private boolean solveSudoku() {
        while (!isSolved()) {
            boolean madeProgress = false;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    SudokuElement element = board.getElement(i, j);

                    if (element.getValue() == SudokuElement.EMPTY) {
                        for (int value : element.getPossibleValues()) {
                            if (isValidInput(i, j, value)) {
                                board.setElementValue(i, j, value);
                                madeProgress = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!madeProgress) {
                if (!backtrack()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean backtrack() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuElement element = board.getElement(i, j);

                if (element.getValue() == SudokuElement.EMPTY) {
                    for (int value : element.getPossibleValues()) {
                        if (isValidInput(i, j, value)) {
                            board.setElementValue(i, j, value);
                            if (solveSudoku()) {
                                return true;
                            } else {
                                board.setElementValue(i, j, SudokuElement.EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getElement(i, j).getValue() == SudokuElement.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidInput(int row, int col, int value) {
        SudokuElement element = board.getElement(row, col);
        if (element.getValue() != SudokuElement.EMPTY) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board.getElement(row, i).getValue() == value ||
                    board.getElement(i, col).getValue() == value) {
                return false;
            }
        }

        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board.getElement(i, j).getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
