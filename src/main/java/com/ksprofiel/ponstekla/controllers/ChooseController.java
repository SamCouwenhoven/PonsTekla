package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.App;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ChooseController{
    @FXML
    private Button addButton;

    @FXML
    private void print(){
        App.loadTestLayout();
    }

}
