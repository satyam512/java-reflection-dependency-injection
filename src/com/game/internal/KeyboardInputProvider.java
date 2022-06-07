package com.game.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class KeyboardInputProvider implements InputProvider {

    private BoardDimensions boardDimensions;
    private Scanner scanner;

    KeyboardInputProvider(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public List<Integer> getInputCoordinates() {
        System.out.println("Selecting Row value between 0 and " + (boardDimensions.getNumberOfRows()-1));
        int inputRowValue = scanner.nextInt();

        System.out.println("Selecting Column value between 0 and " + (boardDimensions.getNumberOfCols()-1));
        int inputColValue = scanner.nextInt();

        return Arrays.asList(inputRowValue, inputColValue);
    }
}
