package org.mkgorka.checkersroyale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.mkgorka.checkersroyale.controller.Controller;
import org.mkgorka.checkersroyale.model.Model;
import org.mkgorka.checkersroyale.view.View;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        Scene scene = new Scene(view.getRoot(), Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setupStage(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupStage(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle(Config.TITLE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}