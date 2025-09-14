package org.mkgorka.checkersroyale.model;

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
}
