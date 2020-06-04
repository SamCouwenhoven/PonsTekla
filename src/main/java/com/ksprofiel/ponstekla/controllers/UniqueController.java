package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import java.io.File;
import com.ksprofiel.ponstekla.models.FileFilter;


public class UniqueController{

    @FXML private GridPane gridPane;
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
