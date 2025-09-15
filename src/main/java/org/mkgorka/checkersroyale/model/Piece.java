package org.mkgorka.checkersroyale.model;

import java.util.ArrayList;

public class Piece {
    private Position POSITION;

    private boolean IS_KING = false;

    private final boolean IS_WHITE;

    public Piece(Position position, boolean isWhite) {
        POSITION = position;
        IS_WHITE = isWhite;
    }

    public Piece(Piece piece) {
        POSITION = piece.POSITION;
        IS_WHITE = piece.IS_WHITE;
    }

    public void setPosition(Position position) {
        POSITION = position;
    }

    public void promote(){
        IS_KING = true;
    }

    public Position getPosition() {
        return POSITION;
    }

    public boolean isWhite() {
        return IS_WHITE;
    }

    public boolean isKing() {
        return IS_KING;
    }

    private boolean canCapture(CheckersBoard board, Position nextMovingPiecePosition, Position beatedPiecePosition){
        return beatedPiecePosition.isWithinBounds()
                && board.getPiece(beatedPiecePosition) != null
                && board.getPiece(beatedPiecePosition).isWhite() != IS_WHITE
                && nextMovingPiecePosition.isWithinBounds()
                && board.getPiece(nextMovingPiecePosition) == null;
    }

    private boolean canMove(CheckersBoard board, Position nextMovingPiecePosition){
        return nextMovingPiecePosition.isWithinBounds()
                && board.getPiece(nextMovingPiecePosition) == null;
    }

    public ArrayList<Move> findMoves(CheckersBoard board, boolean firstCall){
        ArrayList<Move> moves = new ArrayList<>();
        if (IS_KING){
            for (int rowOffset = -1; rowOffset <= 1; rowOffset += 2) {
                for (int colOffset = -1; colOffset <= 1; colOffset += 2) {
                    while (true) {
                        // check capture
                        Position beatedPiecePosition = POSITION.add(rowOffset, colOffset);
                        Position nextMovingPiecePosition = beatedPiecePosition.add(rowOffset, colOffset);
                        if (canCapture(board, nextMovingPiecePosition, beatedPiecePosition)){
                            Move move = new Move(board, this, nextMovingPiecePosition, board.getPiece(beatedPiecePosition));
                            moves.addAll(move.getMovedPiece().findMoves(move.getBoard(), false));
                            break;
                        }
                        // check normal moves
                        nextMovingPiecePosition = beatedPiecePosition;
                        if (firstCall && canMove(board, nextMovingPiecePosition)) {
                            Move move = new Move(board, this, nextMovingPiecePosition, null);
                            moves.add(move);
                        }
                    }
                }
            }
        }

        return moves;
    }
}
