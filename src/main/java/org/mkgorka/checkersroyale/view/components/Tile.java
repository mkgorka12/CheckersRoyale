package org.mkgorka.checkersroyale.view.components;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import org.mkgorka.checkersroyale.view.ViewUtils;

public class Tile extends BorderPane {
    public static final Double SIDE_LENGTH = UICheckersBoard.SIDE_LENGTH / UICheckersBoard.NUMBER_OF_SQUARES_IN_ROW_WITH_OUTLINE;

    private static final Color HIGHLIGHT_COLOR = Color.DARKGREEN;
    private final Color defaultColor;
    private UIPiece uiPiece = null;

    public Tile(Color defaultColor) {
        ViewUtils.setSize(this, SIDE_LENGTH, SIDE_LENGTH);
        this.defaultColor = defaultColor;
        setBackground(ViewUtils.createBasicBackground(defaultColor));
    }

    public void highlight() {
        setBackground(ViewUtils.createBasicBackground(HIGHLIGHT_COLOR));
    }

    public void unHighlight() {
        setBackground(ViewUtils.createBasicBackground(defaultColor));
    }

    public void setPiece(UIPiece uiPiece) {
        this.uiPiece = uiPiece;
        setCenter(uiPiece);
    }

    public UIPiece getPiece() {
        return uiPiece;
    }
}
