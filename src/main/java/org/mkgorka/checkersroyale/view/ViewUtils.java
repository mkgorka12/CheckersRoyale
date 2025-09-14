package org.mkgorka.checkersroyale.view;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.mkgorka.checkersroyale.Config;

public class ViewUtils {
    public static Background createBasicBackground(Color backgroundColor) {
        BackgroundFill backgroundFill = new BackgroundFill(
                backgroundColor,
                CornerRadii.EMPTY,
                Insets.EMPTY
        );
        return new Background(backgroundFill);
    }

    public static void setSize(Pane pane, double width, double height) {
        pane.setPrefSize(width, height);
        pane.setMaxSize(width, height);
        pane.setMinSize(width, height);
    }

    public static Font createDefaultFont(double fontSize) {
        return Font.loadFont(
                View.class.getResourceAsStream(Config.PATH_TO_DEFAULT_FONT),
                fontSize
        );
    }

    public static Text createTextWithDefaultFontColor(Font font, String string) {
        Text text = new Text(string);
        text.setFont(font);
        text.setFill(Config.DEFAULT_FONT_COLOR);
        return text;
    }
}
