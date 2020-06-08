package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.factories.ProfileFactory;
import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.Profile;
import com.ksprofiel.ponstekla.models.Regex;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.util.LinkedList;

import com.ksprofiel.ponstekla.models.FileFilter;


public class UniqueController{

    @FXML private GridPane gridPane;
    private ProfileFactory profileFactory;
    private LinkedList<Profile> profiles;

    public void initData(ObservableList<File> fileObservableList){
        profileFactory = new ProfileFactory(fileObservableList);
        profiles = profileFactory.createAllProfiles();
        buildUniqueView();

    }
    private void buildUniqueView(){
        UniqueViewBuilder uniqueViewBuilder = new UniqueViewBuilder(gridPane);
        uniqueViewBuilder.setUniqueHoleList(createUniqueHoleList());
        uniqueViewBuilder.init();
    }

    private LinkedList<Hole> createUniqueHoleList(){
        LinkedList<Hole> uniqueHoleList = new LinkedList<>();
        for (Profile profile:profiles) {
            Regex.addUniques(profile.getHoles(),uniqueHoleList);
        }
        return uniqueHoleList;
    }
}
