package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.models.Hole;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import com.ksprofiel.ponstekla.models.FileFilter;


public class UniqueController{

    @FXML private GridPane gridPane;

    @FXML private Pane pane;

    private FileFilter fileFilter;



    public void initData(ObservableList<File> fileObservableList){
        fileFilter = new FileFilter(fileObservableList);
        buildUniqueView();

    }
    private void buildUniqueView(){
        UniqueViewBuilder uniqueViewBuilder = new UniqueViewBuilder(gridPane);

        uniqueViewBuilder.setUniqueHoleList(fileFilter.calculateDiffrentHoles());

        uniqueViewBuilder.init();
    }
}
