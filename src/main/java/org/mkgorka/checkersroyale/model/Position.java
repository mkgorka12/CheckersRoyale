package org.mkgorka.checkersroyale.model;

import org.mkgorka.checkersroyale.Constant;

import java.util.Objects;

public class Position {
    private final int ROW;
    private final int COL;

    public Position(int row, int col){
        ROW = row;
        COL = col;
    }

    public Position(Position position){
        ROW = position.ROW;
        COL = position.COL;
    }

    public int getRow() {
        return ROW;
    }

    public int getCol() {
        return COL;
    }

    public boolean isInBlackTile() {
        return (ROW + COL) % 2 == 1;
    }

    public Position add(int rowOffset, int colOffset){
        return new Position(ROW + rowOffset, COL + colOffset);
    }

    public boolean isWithinBounds() {
        return ROW >= 0 && ROW < Constant.NUMBER_OF_SQUARES_IN_ROW
                && COL >= 0 && COL < Constant.NUMBER_OF_SQUARES_IN_ROW;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return this.ROW == other.ROW
                && this.COL == other.COL;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ROW, COL);
    }

    @Override
    public String toString() {
        return "(" + ROW + ", " + COL + ")";
    }
}
