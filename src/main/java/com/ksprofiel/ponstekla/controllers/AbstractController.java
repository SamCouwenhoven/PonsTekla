package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.App;
import com.ksprofiel.ponstekla.models.ViewFile;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AbstractController {
    private final FXMLLoader fxmlLoader;

    protected AbstractController() {
        this.fxmlLoader = new FXMLLoader();
    }

    protected Parent loadFXML(ViewFile layout) {
        try {
            fxmlLoader.setLocation(App.class.getResource(layout.getFileName()));
            return fxmlLoader.load();
        }catch (
                IOException e){
            e.printStackTrace();
        }
        return null;
    }

    protected Stage getStage(Event event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    protected <T> T getController(){
        return fxmlLoader.getController();
    }
}
