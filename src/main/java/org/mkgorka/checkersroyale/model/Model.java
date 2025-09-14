package org.mkgorka.checkersroyale.model;

public class Model {
    private CheckersBoard board = new CheckersBoard();

    public Model() {
        reset();
    }

    public void reset(){
        board.reset();
    }

    public CheckersBoard getCheckersBoard() {
        return board;
    }
}
