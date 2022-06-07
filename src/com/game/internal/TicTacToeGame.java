package com.game.internal;

import com.game.Game;

import java.util.Arrays;
import java.util.List;

public class TicTacToeGame implements Game {

    List<Player> players;
    Board board;
    BoardPrinter boardPrinter;

    public TicTacToeGame(Board board,
                         BoardPrinterImpl boardPrinter,
                         HumanPlayer humanPlayer,
                         ComputerPlayer computerPlayer) {
        this.board = board;
        this.boardPrinter = boardPrinter;
        humanPlayer.setPlayerSign(Sign.X);
        computerPlayer.setPlayerSign(Sign.O);
        this.players = Arrays.asList(humanPlayer, computerPlayer);
    }

    @Override
    public void startNewGame() {
        boolean isAnyWin = false;
        int turn = 0;
        int mod = players.size();

        do {
            Player playerTurn = players.get(turn);
            System.out.println("Player is making move .... ");

            playerTurn.makeMove(board);
            boardPrinter.printBoard(board);

            isAnyWin = board.isWinner(playerTurn);
            if (isAnyWin) {
                System.out.println(String.format("Player %d has won.... But at what cost ? ", (turn+1)));
            }
            turn = (turn + 1)%mod;
        } while (!isAnyWin && !board.isBoardFull());
    }
}
