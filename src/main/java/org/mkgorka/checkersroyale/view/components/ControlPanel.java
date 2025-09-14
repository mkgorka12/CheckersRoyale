package org.mkgorka.checkersroyale.view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import org.mkgorka.checkersroyale.Config;
import org.mkgorka.checkersroyale.view.ViewUtils;

public class ControlPanel extends StackPane {
    private static final Double WIDTH = Config.WINDOW_WIDTH / 4;
    private static final Double HEIGHT = UICheckersBoard.SIDE_LENGTH / 2;
    private static final Double OUTLINE_SIZE = HEIGHT / 50;
    private static final Double SPACING = HEIGHT / 50;
    private static final Double BIG_FONT_SIZE = HEIGHT / 5;
    private static final Double SMALL_FONT_SIZE = BIG_FONT_SIZE / 2;

    private static final int BIG_FONT_SUBSTRING_LENGTH = 10;
    private static final int SMALL_FONT_SUBSTRING_LENGTH = 23;

    private static final int MAX_DISPLAYED_ELEMENTS = 8;

    private static final Color OUTLINE_COLOR = Color.web("#691B1B");
    private static final Color INSIDE_COLOR = Color.web("#380707");

    private final Font BIG_FONT = Font.loadFont(getClass().getResourceAsStream(Config.PATH_TO_DEFAULT_FONT), BIG_FONT_SIZE);
    private final Font SMALL_FONT = Font.loadFont(getClass().getResourceAsStream(Config.PATH_TO_DEFAULT_FONT), SMALL_FONT_SIZE);
    
    private final VBox VBOX;

    public ControlPanel() {
        setBackground(ViewUtils.createBasicBackground(OUTLINE_COLOR));
        setPrefWidth(WIDTH);
        setMaxHeight(HEIGHT);
        setPadding(new Insets(OUTLINE_SIZE, OUTLINE_SIZE, OUTLINE_SIZE, OUTLINE_SIZE));

        VBOX = new VBox();
        VBOX.setBackground(ViewUtils.createBasicBackground(INSIDE_COLOR));
        VBOX.setAlignment(Pos.CENTER);
        VBOX.setPadding(new Insets(OUTLINE_SIZE, OUTLINE_SIZE, OUTLINE_SIZE, OUTLINE_SIZE));
        VBOX.setSpacing(SPACING);
        getChildren().add(VBOX);
    }

    public void displayText(String string, boolean bigFont){
        if (VBOX.getChildren().size() >= MAX_DISPLAYED_ELEMENTS) {
            VBOX.getChildren().removeFirst();
        }
        Font font = bigFont ? BIG_FONT : SMALL_FONT;
        if (bigFont && string.length() > BIG_FONT_SUBSTRING_LENGTH) {
            string = string.substring(0, BIG_FONT_SUBSTRING_LENGTH) + "...";
        } else if (!bigFont && string.length() > SMALL_FONT_SUBSTRING_LENGTH) {
            string = string.substring(0, SMALL_FONT_SUBSTRING_LENGTH) + "...";
        }
        Text text = ViewUtils.createTextWithDefaultFontColor(font, string);
        VBOX.getChildren().add(text);
    }

    public void clear(){
        VBOX.getChildren().clear();
    }
}
