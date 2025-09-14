package org.mkgorka.checkersroyale.view.components;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.mkgorka.checkersroyale.Config;
import org.mkgorka.checkersroyale.Constant;
import org.mkgorka.checkersroyale.model.CheckersBoard;
import org.mkgorka.checkersroyale.model.Position;
import org.mkgorka.checkersroyale.view.ViewUtils;

import java.util.HashMap;

public class UICheckersBoard extends GridPane{
    public static final Double SIDE_LENGTH = Config.WINDOW_WIDTH / 2.5;

    private static final int OUTLINE_WIDTH_IN_SQUARES = 1;

    public static final int NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE
            = Constant.NUMBER_OF_SQUARES_IN_ROW + 2 * OUTLINE_WIDTH_IN_SQUARES;

    private static final Color OUTLINE_COLOR = Color.web("#4D2C17");
    private static final Color BLACK_COLOR = Color.BLACK;
    private static final Color WHITE_COLOR = Color.WHITE;

    private static final Double LABEL_FONT_SIZE = Tile.SIDE_LENGTH / 2;

    private static final Font LABEL_FONT = ViewUtils.createDefaultFont(LABEL_FONT_SIZE);

    private final HashMap<Position, Tile> gameArea = new HashMap<>();

    public UICheckersBoard() {
        ViewUtils.setSize(this, SIDE_LENGTH, SIDE_LENGTH);
        for (int row = 0; row < NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE; ++row) {
            for (int col = 0; col < NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE; ++col) {
                createTile(new Position(row, col));
            }
        }
    }

    private boolean isTilePositionInGameArea(Position position) {
        return position.getRow() >= UICheckersBoard.OUTLINE_WIDTH_IN_SQUARES
                && position.getRow() < UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES
                && position.getCol() >= UICheckersBoard.OUTLINE_WIDTH_IN_SQUARES
                && position.getCol() < UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES;
    }

    private void add(Node node, Position position){
        add(node, position.getCol(), position.getRow());
    }

    private boolean shouldAddNumberToTile(Position position) {
        return  (position.getCol() == 0
                || position.getCol() == UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES)
                && (position.getRow() != 0
                && position.getRow() != UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES);
    }

    private boolean shouldAddLetterToTile(Position position) {
        return  (position.getRow() == 0
                || position.getRow() == UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES)
                && (position.getCol() != 0
                && position.getCol() != UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - OUTLINE_WIDTH_IN_SQUARES);
    }

    private void addLabelToTile(Tile tile, String labelString)
    {
        Text sideLabel = ViewUtils.createTextWithDefaultFontColor(LABEL_FONT, labelString);
        tile.setCenter(sideLabel);
    }

    private void createTile(Position position) {
        Color color;
        String label = null;
        if (!isTilePositionInGameArea(position)) {
            color = OUTLINE_COLOR;
            if (shouldAddNumberToTile(position)) {
                label = String.valueOf((char) (UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE - position.getRow() - 2 + '1'));
            } else if (shouldAddLetterToTile(position)) {
                label = String.valueOf((char) (position.getCol() - 1 + 'A'));
            }
        } else if (position.isInBlackTile()){
            color = BLACK_COLOR;
        } else {
            color = WHITE_COLOR;
        }

        Tile tile = new Tile(color);
        if (label != null) {
            addLabelToTile(tile, label);
        }

        add(tile, position);

        if (isTilePositionInGameArea(position) && position.isInBlackTile()) { // gameArea doesn't include outline
            Position logicalTilePosition = new Position(
                    position.getRow() - OUTLINE_WIDTH_IN_SQUARES,
                    position.getCol() - OUTLINE_WIDTH_IN_SQUARES
            );
            tile.setPiece(new UIPiece());
            gameArea.put(logicalTilePosition, tile);
        }
    }

    public Tile get(Position position) {
        return gameArea.get(position);
    }

    public void update(CheckersBoard checkersBoard) {
        for (Position position : gameArea.keySet()) {
            if (checkersBoard.getPiece(position) == null) {
                Tile tile = get(position);
                tile.getPiece().hide();
            } else {
                Tile tile = get(position);
                tile.getPiece().show(checkersBoard.getPiece(position));
            }
        }
    }
}