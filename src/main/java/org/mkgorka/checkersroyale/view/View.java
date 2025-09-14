package org.mkgorka.checkersroyale.view;

import javafx.scene.layout.BorderPane;

import org.mkgorka.checkersroyale.view.components.Footer;
import org.mkgorka.checkersroyale.view.components.Navbar;
import org.mkgorka.checkersroyale.view.components.Body;

public class View {
    private final BorderPane ROOT;
    private final Navbar NAVBAR;
    private final Body BODY;
    private final Footer FOOTER;

    public View() {
        ROOT = new BorderPane();
        NAVBAR = new Navbar();
        BODY = new Body();
        FOOTER = new Footer();

        ROOT.setTop(NAVBAR);
        ROOT.setCenter(BODY);
        ROOT.setBottom(FOOTER);
    }

    public BorderPane getRoot() {
        return ROOT;
    }

    public Body getBody() {
        return BODY;
    }
}
