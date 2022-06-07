package com.game.internal;

import java.util.Arrays;
import java.util.Optional;

class BoardPrinterImpl implements BoardPrinter {

    private BoardDimensions boardDimensions;

    public BoardPrinterImpl(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
    }

    public void printBoard(Board gameBoard) {
        for ( int i = 0; i < boardDimensions.getNumberOfRows(); i++) {
            for (int j = 0; j < boardDimensions.getNumberOfCols(); j++) {
                System.out.print("|");
                Optional<Cell> currCell = gameBoard.findCellIfExists(new Cell(Arrays.asList(i, j), Sign.EMPTY));
                if (currCell.isPresent()) {
                    currCell.get().printDetails();
                } else {
                    Cell.printEmptyCell();
                }
            }
            System.out.println("|");
        }
    }
}