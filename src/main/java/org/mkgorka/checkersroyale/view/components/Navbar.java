package org.mkgorka.checkersroyale.view.components;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

import org.mkgorka.checkersroyale.Config;
import org.mkgorka.checkersroyale.view.ViewUtils;

public class Navbar extends HBox {
    private static final Double HEIGHT = Config.WINDOW_HEIGHT / 10;
    private static final Double FONT_SIZE = HEIGHT / 1.5;

    private static final Color BACKGROUND_COLOR = Color.web("#550101");

    public Navbar() {
        ViewUtils.setSize(this, Config.WINDOW_WIDTH, HEIGHT);
        setBackground(ViewUtils.createBasicBackground(BACKGROUND_COLOR));
        setAlignment(Pos.CENTER);
        addTitle();
    }

    private void addTitle() {
        Font font = ViewUtils.createDefaultFont(FONT_SIZE);
        Text title = ViewUtils.createTextWithDefaultFontColor(font, Config.TITLE);
        getChildren().add(title);
    }
}
