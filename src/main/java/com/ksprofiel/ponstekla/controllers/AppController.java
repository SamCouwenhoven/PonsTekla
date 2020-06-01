package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.models.ViewFile;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController extends AbstractController{

    public Scene getScene(){
        Parent chooseViewParent = loadFXML(ViewFile.CHOOSE);

        return new Scene(chooseViewParent);
    }
}
