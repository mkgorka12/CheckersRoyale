package org.mkgorka.checkersroyale.view.components;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import org.mkgorka.checkersroyale.Config;
import org.mkgorka.checkersroyale.view.ViewUtils;

public class Footer extends HBox {
    private static final Double HEIGHT = Config.WINDOW_HEIGHT / 20;
    private static final Double FONT_SIZE = HEIGHT / 2;

    private static final Color BACKGROUND_COLOR = Color.web("#550101");

    private static final String COPYRIGHT_TEXT = "Created by mkgorka";

    public Footer() {
        ViewUtils.setSize(this, Config.WINDOW_WIDTH, HEIGHT);
        setBackground(ViewUtils.createBasicBackground(BACKGROUND_COLOR));
        setAlignment(Pos.CENTER);
        addCopyrightText();
    }

    private void addCopyrightText() {
        Font font = ViewUtils.createDefaultFont(FONT_SIZE);
        Text title = ViewUtils.createTextWithDefaultFontColor(font, COPYRIGHT_TEXT);
        getChildren().add(title);
    }
}
