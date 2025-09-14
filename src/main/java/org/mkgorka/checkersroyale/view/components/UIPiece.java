package org.mkgorka.checkersroyale.view.components;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import org.mkgorka.checkersroyale.model.Piece;

public class UIPiece extends StackPane {
    private static final Color WHITE_PIECE_MAIN_COLOR = Color.web("#A2A2A2");
    private static final Color WHITE_PIECE_ADDITIONAL_COLOR = Color.web("#B3B3B3");
    private static final Color BLACK_PIECE_MAIN_COLOR = Color.web("#3B3B3B");
    private static final Color BLACK_PIECE_ADDITIONAL_COLOR = Color.web("#484848");
    private static final Color SELECTED_PIECE_HIGHLIGHT_COLOR = Color.BLUE;
    private static final Color ENDANGERED_PIECE_HIGHLIGHT_COLOR = Color.RED;

    private static final Double PIECE_SIZE = Tile.SIDE_LENGTH / 2 - Tile.SIDE_LENGTH / 20;
    private static final Double OUTLINE_CIRCLE_SIZE = PIECE_SIZE;
    private static final Double EXTERNAL_CIRCLE_SIZE = PIECE_SIZE / 1.25;
    private static final Double RING_SIZE = PIECE_SIZE / 1.7;
    private static final Double INTERNAL_CIRCLE_SIZE = PIECE_SIZE / 2;

    private final Circle outlineCircle;
    private final Circle externalCircle;
    private final Circle ringCircle;
    private final Circle internalCircle;

    private Color mainColor = WHITE_PIECE_MAIN_COLOR;
    private Color additionalColor = WHITE_PIECE_ADDITIONAL_COLOR;

    private boolean isWhite = false;
    private boolean isKing = false;

    public UIPiece() {
        outlineCircle = createNewLayer(OUTLINE_CIRCLE_SIZE);
        externalCircle = createNewLayer(EXTERNAL_CIRCLE_SIZE);
        ringCircle = createNewLayer(RING_SIZE);
        internalCircle = createNewLayer(INTERNAL_CIRCLE_SIZE);

        setVisibility(false);

        getChildren().addAll(outlineCircle, externalCircle, ringCircle, internalCircle);
    }

    private void setVisibility(boolean visible){
        outlineCircle.setVisible(visible);
        externalCircle.setVisible(visible);
        ringCircle.setVisible(visible);
        internalCircle.setVisible(visible);
    }

    private void update(boolean isWhite, boolean isKing) {
        if (isWhite) {
            mainColor = WHITE_PIECE_MAIN_COLOR;
            additionalColor = WHITE_PIECE_ADDITIONAL_COLOR;
        } else {
            mainColor = BLACK_PIECE_MAIN_COLOR;
            additionalColor = BLACK_PIECE_ADDITIONAL_COLOR;
        }

        this.isKing = isKing;
        if (isKing) {
            outlineCircle.setFill(additionalColor);
            externalCircle.setFill(mainColor);
            ringCircle.setFill(mainColor);
            internalCircle.setFill(mainColor);
        } else {
            outlineCircle.setFill(mainColor);
            externalCircle.setFill(mainColor);
            ringCircle.setFill(additionalColor);
            internalCircle.setFill(mainColor);
        }
    }

    public void show(Piece piece){
        update(piece.isWhite(), piece.isKing());
        setVisibility(true);
    }

    public void hide(){
        setVisibility(false);
    }

    private Circle createNewLayer(Double size) {
        Circle circle = new Circle();
        circle.setRadius(size);
        return circle;
    }

    public void highlightSelected() {
        outlineCircle.setFill(SELECTED_PIECE_HIGHLIGHT_COLOR);
    }

    public void unHighlight() {
        if (!isKing){
            outlineCircle.setFill(mainColor);
        } else {
            outlineCircle.setFill(additionalColor);
        }
    }

    public void highlightEndangered() {
        outlineCircle.setFill(ENDANGERED_PIECE_HIGHLIGHT_COLOR);
    }
}
