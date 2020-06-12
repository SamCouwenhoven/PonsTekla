package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.factories.ProfileFactory;
import com.ksprofiel.ponstekla.models.Contour;
import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.Profile;
import com.ksprofiel.ponstekla.models.Regex;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.util.LinkedList;

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
        uniqueViewBuilder.setUniqueHoleList(createUniqueHoleList());
        uniqueViewBuilder.setUniqueContourList(createUniqueContourList());
        uniqueViewBuilder.init();
    }

    private LinkedList<Hole> createUniqueHoleList(){
        LinkedList<Hole> uniqueHoleList = new LinkedList<>();
        for (Profile profile:profiles) {
            Regex.addUniques(profile.getHoles(),uniqueHoleList);
        }
        return uniqueHoleList;
    }

    private LinkedList<Contour> createUniqueContourList(){
        LinkedList<Contour> uniqueContourList = new LinkedList<>();

        for (Profile profile:profiles){
            Regex.addUniques(profile.getContourAK(),uniqueContourList);
        }

        return uniqueContourList;
    }
}
