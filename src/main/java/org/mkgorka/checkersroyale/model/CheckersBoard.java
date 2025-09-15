package org.mkgorka.checkersroyale.model;

import org.mkgorka.checkersroyale.Constant;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckersBoard {
    private static final int NUMBER_OF_PIECE_ROWS = 3;

    private final Piece[][] BOARD = new Piece[Constant.NUMBER_OF_SQUARES_IN_ROW][Constant.NUMBER_OF_SQUARES_IN_ROW];
    private final HashMap<Position, Piece> WHITE_PIECES = new HashMap<>();
    private final HashMap<Position, Piece> BLACK_PIECES = new HashMap<>();

    public CheckersBoard(){
        reset();
    }

    public CheckersBoard(CheckersBoard board){
        for (int row = 0; row < Constant.NUMBER_OF_SQUARES_IN_ROW; ++row) {
            for (int col = 0; col < Constant.NUMBER_OF_SQUARES_IN_ROW; ++col) {
                BOARD[row][col] = board.BOARD[row][col];

                if (board.BOARD[row][col] != null) {
                    Position position = new Position(row, col);
                    Piece piece = new Piece(board.BOARD[row][col]);

                    if (board.BOARD[row][col].isWhite()) {
                        WHITE_PIECES.put(position, piece);
                    } else {
                        BLACK_PIECES.put(position, piece);
                    }
                }
            }
        }
    }

    private Piece createPiece(Position position) {
        Piece piece = null;
        boolean isInBlackTile = position.isInBlackTile();
        if (isInBlackTile && position.getRow() < NUMBER_OF_PIECE_ROWS) {
            piece = new Piece(position, false);
            BLACK_PIECES.put(position, piece);
        } else if (isInBlackTile && position.getRow() >= Constant.NUMBER_OF_SQUARES_IN_ROW - NUMBER_OF_PIECE_ROWS) {
            piece = new Piece(position, true);
            WHITE_PIECES.put(position, piece);
        }
        return piece;
    }

    public void reset() {
        WHITE_PIECES.clear();
        BLACK_PIECES.clear();
        for (int row = 0; row < Constant.NUMBER_OF_SQUARES_IN_ROW; ++row) {
            for (int col = 0; col < Constant.NUMBER_OF_SQUARES_IN_ROW; ++col) {
                BOARD[row][col] = createPiece(new Position(row, col));
            }
        }
    }

    public Piece getPiece(Position position){
        return BOARD[position.getRow()][position.getCol()];
    }

    public void setPiece(Position position, Piece piece){
        BOARD[position.getRow()][position.getCol()] = piece;
    }

    public ArrayList<Piece> getWhitePieces() {
        return new ArrayList<>(WHITE_PIECES.values());
    }

    public ArrayList<Piece> getBlackPieces() {
        return new ArrayList<>(BLACK_PIECES.values());
    }
}
