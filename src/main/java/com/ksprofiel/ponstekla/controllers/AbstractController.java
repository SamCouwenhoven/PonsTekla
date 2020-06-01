package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.App;
import com.ksprofiel.ponstekla.models.ViewFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class AbstractController implements Controller {
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

    protected <T> T getController(){
        return fxmlLoader.getController();
    }
}
