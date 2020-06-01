package com.ksprofiel.ponstekla;

import com.ksprofiel.ponstekla.models.ScreenLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) {
        App.stage = stage;
        loadStartScreen();
        stage.show();
    }

    private static Parent loadFXML(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/" + fxml + ".fxml"));
            return fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static void loadStartScreen(){
        loadStage(ScreenLayout.CHOOSE_LAYOUT);
    }

    public static void loadTestLayout(){
        loadStage(ScreenLayout.TEST_LAYOUT);
    }

    private static void loadStage(ScreenLayout screenLayout){
        stage.setScene(new Scene(loadFXML(screenLayout.getFileName())));
    }

    public static void main(String[] args) {
        launch();
    }
}
