package com.game.internal;

class BoardDimensions {

    private static final Integer NUMBER_OF_ROWS = 3;
    private static final Integer NUMBER_OF_COLS = 3;

    public Integer getNumberOfCols() {
        return NUMBER_OF_COLS;
    }

    public Integer getNumberOfRows() {
        return NUMBER_OF_ROWS;
    }

    public Integer getBoardSize() {
        return NUMBER_OF_COLS*NUMBER_OF_ROWS;
    }

}
