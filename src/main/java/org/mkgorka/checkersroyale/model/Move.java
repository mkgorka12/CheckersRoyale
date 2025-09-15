package org.mkgorka.checkersroyale.model;

import java.util.ArrayList;

public class Move {
    private final CheckersBoard BOARD;
    private final Piece MOVING_PIECE;
    private final ArrayList<Position> ROUTE;
    private final ArrayList<Piece> CAPTURED_PIECES;

    public Move(CheckersBoard board, Piece movingPiece, Position toPosition, Piece capturedPiece){
        BOARD = new CheckersBoard(board);
        BOARD.setPiece(movingPiece.getPosition(), null);
        BOARD.setPiece(toPosition, movingPiece);

        ROUTE = new ArrayList<>();
        ROUTE.add(new Position(movingPiece.getPosition()));
        ROUTE.add(new Position(toPosition));

        MOVING_PIECE = new Piece(toPosition, movingPiece.isWhite());

        CAPTURED_PIECES = new ArrayList<>();
        if (capturedPiece != null){
            CAPTURED_PIECES.add(new Piece(capturedPiece));
            BOARD.setPiece(capturedPiece.getPosition(), null);
        } else {
            CAPTURED_PIECES.add(null);
        }
    }

    public void addRoute(Position position){
        ROUTE.add(position);
    }

    public void addCapturedPiece(Piece capturedPiece){
        CAPTURED_PIECES.add(new Piece(capturedPiece));
    }

    public CheckersBoard getBoard(){
        return BOARD;
    }

    public Piece getMovedPiece(){
        return MOVING_PIECE;
    }
}
