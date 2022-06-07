package com.game.internal;

public class TestRunner {
    public static void main(String[] args) {
        // trying is game works

        BoardDimensions boardDimensions = new BoardDimensions();
        KeyboardInputProvider keyboardInputProvider = new KeyboardInputProvider(boardDimensions);
        HumanPlayer humanPlayer = new HumanPlayer(keyboardInputProvider);

        ComputerInputProvider computerInputProvider = new ComputerInputProvider(boardDimensions);
        ComputerPlayer computerPlayer = new ComputerPlayer(computerInputProvider);

        Board board = new Board(boardDimensions);
        BoardPrinterImpl boardPrinter = new BoardPrinterImpl(boardDimensions);

        TicTacToeGame ticTacToeGame = new TicTacToeGame(board, boardPrinter,humanPlayer, computerPlayer);

        ticTacToeGame.startNewGame();
    }
}
