package org.mkgorka.checkersroyale.model;

import java.util.ArrayList;

public class Model {
    private CheckersBoard board = new CheckersBoard();
    private boolean isWhiteTurn = true;

    public Model() {
        reset();
    }

    public void reset(){
        board.reset();
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void toggleTurn(){
        isWhiteTurn = !isWhiteTurn;
    }

    public CheckersBoard getCheckersBoard() {
        return board;
    }

    public static ArrayList<Move> findMoves(CheckersBoard board, boolean isWhiteTurn){
        ArrayList<Move> moves = new ArrayList<>();
        ArrayList<Piece> pieces = isWhiteTurn ? board.getWhitePieces() : board.getBlackPieces();

        for (Piece piece : pieces) {

        }

        return moves;
    }
}
