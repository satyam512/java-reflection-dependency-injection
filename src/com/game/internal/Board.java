package com.game.internal;

import java.util.*;

class Board {

    private BoardDimensions boardDimensions;
    private List<Cell> boardCells;

    public Board(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
        boardCells = new ArrayList<>();
    }

    public boolean addCell(Cell cell) {
        if (findCellIfExists(cell).isPresent()) {
            return false;
        }
        return boardCells.add(cell);
    }

    public Optional<Cell> findCellIfExists(Cell cell) {
        return boardCells.stream().filter(currCell -> currCell.checkIfCellCoordinatesMatch(cell)).findFirst();
    }

    public List<Cell> getBoardCells() {
        return boardCells;
    }

    public boolean isBoardFull() {
        return boardCells.size() == boardDimensions.getBoardSize();
    }

    public boolean isWinner(Player player) {
        for (int i=0; i < boardDimensions.getNumberOfRows(); i++) {
            int columnCount = 0;
            for(int j = 0; j < boardDimensions.getNumberOfCols(); j++) {
                Cell currCell = new Cell(Arrays.asList(i, j), player.getSign());
                if (boardCells.stream().anyMatch(cell -> currCell.equals(cell))) {
                    columnCount++;
                }
            }
            if (columnCount == boardDimensions.getNumberOfCols())
                return true;
        }

        for (int i=0; i < boardDimensions.getNumberOfCols(); i++) {
            int rowCount = 0;
            for(int j = 0; j < boardDimensions.getNumberOfRows(); j++) {
                Cell currCell = new Cell(Arrays.asList(j, i), player.getSign());
                if (boardCells.stream().anyMatch(cell -> currCell.equals(cell))) {
                    rowCount++;
                }
            }
            if (rowCount == boardDimensions.getNumberOfRows())
                return true;
        }

        if(boardDimensions.getNumberOfRows() == boardDimensions.getNumberOfCols()) {
            int diagonalCountLeft = 0;
            int diagonalCountRight = 0;

            for(int i=0;i< boardDimensions.getNumberOfRows();i++) {
                Cell currCell1 = new Cell(Arrays.asList(i, i), player.getSign());
                if (boardCells.stream().anyMatch(cell -> currCell1.equals(cell))) {
                    diagonalCountLeft++;
                }

                Cell currCell2 = new Cell(Arrays.asList(i, boardDimensions.getNumberOfCols() - i - 1), player.getSign());
                if (boardCells.stream().anyMatch(cell -> currCell2.equals(cell))) {
                    diagonalCountRight++;
                }
            }
            if (diagonalCountLeft == boardDimensions.getNumberOfRows() ||
                    diagonalCountRight == boardDimensions.getNumberOfRows()) {
                return true;
            }
        }

        return false;
    }

}
