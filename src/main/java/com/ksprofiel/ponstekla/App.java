package com.ksprofiel.ponstekla;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println();
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("views/choose_view_v1.fxml")).load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
