package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.builders.UniqueViewBuilder;
import com.ksprofiel.ponstekla.factories.PonsFileFactory;
import com.ksprofiel.ponstekla.factories.ProfileFactory;
import com.ksprofiel.ponstekla.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import java.io.File;
import java.util.*;

public class UniqueController extends AbstractController{

    public TextField pathTextField;
    @FXML private GridPane gridPane;
    private LinkedList<Profile> profiles;

    /**
     *
     * initalizes data used by the controller
     * @param fileObservableList list of files to use
     */
    public void initData(ObservableList<File> fileObservableList){
        ProfileFactory profileFactory = new ProfileFactory();
        profiles = profileFactory.createAllProfiles(fileObservableList);
        buildUniqueView();
    }

    /**
     * build the unique view using UniqueViewBuilder
     */
    private void buildUniqueView(){
        UniqueViewBuilder uniqueViewBuilder = new UniqueViewBuilder(gridPane);
        uniqueViewBuilder.setHoleSet(createHoleSet());
        uniqueViewBuilder.init();
    }

    /**
     * creates a set of Holes from all profiles
     * @return HashSet of Holes
     */
    private Set<Hole> createHoleSet(){
        Set<Hole> holeSet = new HashSet<>();
        for (Profile profile:profiles) {
            holeSet.addAll(profile.getHoles());
        }
        return holeSet;
    }

    /**
     * sets uNrs of profile
     * writes profile to ponsFile using PonsFileFactory
     */
    @FXML
    private void writeFiles(){
        setProfileUNr();

        PonsFileFactory ponsFileFactory = new PonsFileFactory();
        for (Profile profile : profiles) {
            createFile(ponsFileFactory,profile);
        }
    }

    /**
     * creates a PonsFile from Profile
     * @param ponsFileFactory PonsfileFactory used to make PonsFile
     * @param profile profile to convert to PonsFile
     */
    private void createFile(PonsFileFactory ponsFileFactory, Profile profile){
        ponsFileFactory.setProfile(profile);
        String text = ponsFileFactory.createPonsFile();
        String profileName = profile.getName();
        WriteFile.write(text,pathTextField.getText() + "/" + profileName.substring(0,profileName.indexOf(".")));
    }

    /**
     * sets all uNr of profile to the correct uNr
     */
    private void setProfileUNr(){
        Set<Hole> holeSet = createHoleSetWithUNr();

        for (Profile profile:profiles){

            for (Hole hole:profile.getHoles()) {
                setHoleUNr(hole,holeSet);
            }

        }
    }

    /**
     * Set uNr of Hole to uNr of Set
     * @param hole
     * @param holeSet
     */
    private void setHoleUNr(Hole hole, Set<Hole> holeSet){
        for (Hole uniqueHole:holeSet) {
            if (hole.equals(uniqueHole)) {
                hole.setUNr(uniqueHole.getUNr());
                return;
            }
        }
    }

    /**
     * creates holeset of data from uniqueView
     * @return HoleSet with Unr with data from uniqueView
     */
    private Set<Hole> createHoleSetWithUNr(){
        ListIterator children = gridPane.getChildren().listIterator();
        Set<Hole> holeSet = new HashSet<>();
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
                holeSet.add(uniqueHole);
            }
            number++;
        }
        return holeSet;
    }

    /**
     *selects directory where files will be created
     */
    @FXML
    private void selectPath(MouseEvent mouseEvent) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(getStage(mouseEvent));
        if (selectedDirectory != null){
            pathTextField.setText(selectedDirectory.getPath());
        }

    }
}
