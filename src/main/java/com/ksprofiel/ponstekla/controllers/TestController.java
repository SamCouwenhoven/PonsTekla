package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.models.Hole;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import com.ksprofiel.ponstekla.models.FileFilter;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML private GridPane gridPane;

    @FXML private Pane pane;

    private FileFilter fileFilter;



    public void initData(ObservableList<File> fileObservableList){
        fileFilter = new FileFilter(fileObservableList);
        LinkedList<Hole> uniqueList = fileFilter.calculateDiffrentHoles();
        int i = 0;
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        for (Hole hole:uniqueList) {
            gridPane.add(new Label(hole.getSide()),0,i,1,1);
            gridPane.add(new Label(Double.toString(hole.getY())),2,i,1,1);
            gridPane.add(new Label(Double.toString(hole.getSize())),3,i,1,1);
            i++;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         {
        }
    }
}
