package com.game.internal;

import java.util.List;

class HumanPlayer implements Player {
    KeyboardInputProvider keyboardInputProvider;

    private Sign playerSign;

    @Override
    public void makeMove(Board gameBoard) {
        while (true){
            List<Integer> moveCoordinates = keyboardInputProvider.getInputCoordinates();
            Cell gameCell = new Cell(moveCoordinates, playerSign);
            if (gameBoard.findCellIfExists(gameCell).isPresent()) {
                System.out.println("Selected cell already exist, choose again");
                continue;
            }
            gameBoard.addCell(gameCell);
            break;
        }
    }

    HumanPlayer(KeyboardInputProvider keyboardInputProvider) {
        this.keyboardInputProvider = keyboardInputProvider;
    }

    public void setPlayerSign(Sign sign) {
        playerSign = sign;
    }

    @Override
    public Sign getSign() {
        return playerSign;
    }
}
