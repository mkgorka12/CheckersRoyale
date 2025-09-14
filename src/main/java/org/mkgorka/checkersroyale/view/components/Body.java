package org.mkgorka.checkersroyale.view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import org.mkgorka.checkersroyale.Config;
import org.mkgorka.checkersroyale.view.ViewUtils;

public class Body extends HBox {
    private static final Double SPACING = Config.WINDOW_WIDTH / 15;

    private static final Color BACKGROUND_COLOR = Color.web("#410000");

    private final UICheckersBoard CHECKERS_BOARD;
    private final ControlPanel CONTROL_PANEL;

    public Body() {
        setBackground(ViewUtils.createBasicBackground(BACKGROUND_COLOR));
        setAlignment(Pos.CENTER);
        setSpacing(SPACING);

        CHECKERS_BOARD = new UICheckersBoard();
        CONTROL_PANEL = new ControlPanel();
        getChildren().addAll(CHECKERS_BOARD, CONTROL_PANEL);
    }

    public UICheckersBoard getCheckersBoard() {
        return CHECKERS_BOARD;
    }

    public ControlPanel getControlPanel(){
        return CONTROL_PANEL;
    }
}
