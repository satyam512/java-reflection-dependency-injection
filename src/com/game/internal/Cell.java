package com.game.internal;

import java.util.List;
import java.util.Objects;

class Cell {
    private Sign sign;
    private List<Integer> cellCoordinates;

    public Cell(List<Integer> cellCoordinates, Sign sign) {
        this.cellCoordinates = cellCoordinates;
        this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }

    public List<Integer> getCellCoordinates() {
        return cellCoordinates;
    }

    public boolean checkIfCellCoordinatesMatch(Cell cell) {
        return this.cellCoordinates.equals(cell.cellCoordinates);
    }

    public void printDetails() {
        sign.print();
    }

    public static void printEmptyCell() {
        Sign.EMPTY.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return getSign().equals(cell.getSign()) && getCellCoordinates().equals(cell.getCellCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSign(), getCellCoordinates());
    }
}
