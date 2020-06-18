package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.factories.ProfileFactory;
import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.Profile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UniqueController{

    @FXML private GridPane gridPane;
    private LinkedList<Profile> profiles;

    public void initData(ObservableList<File> fileObservableList){
        ProfileFactory profileFactory = new ProfileFactory();
        profiles = profileFactory.createAllProfiles(fileObservableList);
        buildUniqueView();

    }
    private void buildUniqueView(){
        UniqueViewBuilder uniqueViewBuilder = new UniqueViewBuilder(gridPane);
        uniqueViewBuilder.setHoleSet(createUniqueHoleList());
        uniqueViewBuilder.init();
    }

    private Set<Hole> createUniqueHoleList(){
        Set<Hole> holeSet = new HashSet<>();
        for (Profile profile:profiles) {
            holeSet.addAll(profile.getHoles());
        }
        return holeSet;
    }

}
