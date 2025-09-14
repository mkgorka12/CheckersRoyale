package org.mkgorka.checkersroyale.controller;

import org.mkgorka.checkersroyale.model.Model;
import org.mkgorka.checkersroyale.view.View;

public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        view.getBody().getControlPanel().displayText("WIP", true);
        view.getBody().getCheckersBoard().update(model.getCheckersBoard());
    }
}
