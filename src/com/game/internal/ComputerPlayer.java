package com.game.internal;

import java.util.List;

class ComputerPlayer implements Player {

    ComputerInputProvider computerInputProvider;

    private Sign playerSign;

    ComputerPlayer(ComputerInputProvider computerInputProvider) {
        this.computerInputProvider = computerInputProvider;
    }

    @Override
    public void makeMove(Board gameBoard) {
        while (true) {
            List<Integer> moveCoordinates = computerInputProvider.getInputCoordinates();
            Cell gameCell = new Cell(moveCoordinates, playerSign);
            if (gameBoard.findCellIfExists(gameCell).isPresent()) {
                continue;
            }
            gameBoard.addCell(gameCell);
            break;
        }
    }

    @Override
    public Sign getSign() {
        return playerSign;
    }

    public void setPlayerSign(Sign playerSign) {
        this.playerSign = playerSign;
    }
}
