package com.ksprofiel.ponstekla.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestController {
    @FXML
    private Button test;

    public void initData(String message){
        test.setText(message);
    }
}
