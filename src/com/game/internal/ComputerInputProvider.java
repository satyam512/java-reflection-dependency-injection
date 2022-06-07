package com.game.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class ComputerInputProvider implements InputProvider{
    private BoardDimensions boardDimensions;

    private Random random;

    ComputerInputProvider(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
        random = new Random();
    }

    @Override
    public List<Integer> getInputCoordinates() {
        int inputRowValue = random.nextInt(boardDimensions.getNumberOfRows());
        int inputColValue = random.nextInt(boardDimensions.getNumberOfCols());
        return Arrays.asList(inputRowValue, inputColValue);
    }
}
