package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.factories.PonsFileFactory;
import com.ksprofiel.ponstekla.factories.ProfileFactory;
import com.ksprofiel.ponstekla.models.FileFilter;
import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.Profile;
import com.ksprofiel.ponstekla.models.WriteFile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class UniqueController extends AbstractController{

    public TextField pathTextField;
    @FXML private GridPane gridPane;
    @FXML private Button submitButton;
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

    @FXML
    private void writeFiles(){
        ListIterator children = gridPane.getChildren().listIterator();
        Set<Hole> holeList = new HashSet<>();
        Integer number = -1;
        for (ListIterator it = children; it.hasNext(); ) {
            Node node = (Node) it.next();
            if (node.getId() != null && node.getId().startsWith(number.toString())){

                Label sideLabel = (Label) node;
                Label yLabel = (Label) it.next();
                Label sizeLabel = (Label) it.next();
                TextField uNrText = (TextField) it.next();

                String side = sideLabel.getText();
                double y = Double.parseDouble( yLabel.getText() );
                double size = Double.parseDouble(sizeLabel.getText());
                int unr = Integer.parseInt( uNrText.getText() );

                Hole uniqueHole = new Hole(side,y,size,unr);
                holeList.add(uniqueHole);
            }
            number++;
        }

        for (Hole hole:holeList){
            System.out.println(hole);
        }

        for (Profile profile:profiles){

            for (Hole hole:profile.getHoles()
                 ) {

                for (Hole uniqueHole:holeList
                     ) {
                    if (hole.equals(uniqueHole)) {
                        hole.setUNr(uniqueHole.getUNr());
                    }
                }

            }

        }

        PonsFileFactory ponsFileFactory = new PonsFileFactory();
        for (Profile profile : profiles) {
            ponsFileFactory.setProfile(profile);
            String text = ponsFileFactory.createPonsFile();
            String profileName = profile.getName();
            WriteFile.write(text,pathTextField.getText() + "/" + profileName.substring(0,profileName.indexOf(".")));
        }
    }

    public void selectPath(MouseEvent mouseEvent) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(getStage(mouseEvent));
        if (selectedDirectory != null){
            pathTextField.setText(selectedDirectory.getPath());
        }

    }
}
