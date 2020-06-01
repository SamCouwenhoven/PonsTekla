package com.ksprofiel.ponstekla.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class TestController {

    @FXML private Pane leftPane;

    @FXML private Pane pane;



    public void initData(String message){
        leftPane.getChildren().add(new Label("1"));
    }

    @FXML
    public void addButton(){
        leftPane.getChildren().add(new Label("beer"));
    }
}
