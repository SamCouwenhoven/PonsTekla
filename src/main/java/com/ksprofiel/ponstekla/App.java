package com.ksprofiel.ponstekla;
import com.ksprofiel.ponstekla.controllers.AppController;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        AppController controller = new AppController();
        stage.setScene(controller.getScene());
        stage.setTitle("PonsTekla");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
