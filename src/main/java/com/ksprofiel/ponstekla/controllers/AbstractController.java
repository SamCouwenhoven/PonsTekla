package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.App;
import com.ksprofiel.ponstekla.models.ViewFile;
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

    /**
     * loads fxmlFile
     * @param layout ViewFile layout
     * @return the loaded fxml file as a parent using FXMLLoader
     */
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

    /**
     * @param event any event
     * @return stage of the event
     */
    protected Stage getStage(Event event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    /**
     *
     * @return controller of fxmlLoader
     */
    protected <T> T getController(){
        return fxmlLoader.getController();
    }
}
