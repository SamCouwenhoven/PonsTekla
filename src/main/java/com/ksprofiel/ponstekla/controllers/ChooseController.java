package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.models.ViewFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class ChooseController extends AbstractController implements Initializable {

    @FXML private ListView<File> fileListView;
    @FXML private ListView<String> readFileListView;
    private final ObservableList<File> fileList;

    public ChooseController() {
        this.fileList = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void addFiles(ActionEvent event){

        FileChooser fileChooser =  new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.nc","*.nc1");
        fileChooser.getExtensionFilters().add(extFilter);

        List<File> chosenFiles = fileChooser.showOpenMultipleDialog(getStage(event));

        fileList.addAll(chosenFiles);
        updateListView();
    }


    private void updateListView(){
        fileListView.getItems().clear();
        for (File file : fileList){
            fileListView.getItems().add(file);
        }
    }

    @FXML
    private void readFile(){
        File fileToRead = fileListView.getSelectionModel().getSelectedItem();

        if (fileToRead == null){return;}

        readFileListView.getItems().clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                readFileListView.getItems().add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void removeSelectedFiles(){
        ObservableList<File> filesToRemove = fileListView.getSelectionModel().getSelectedItems();
        fileList.removeAll(filesToRemove);
        updateListView();
    }

    @FXML
    private void print(ActionEvent event){


    }

    @FXML
    private void toNextView(ActionEvent event){
        Parent testViewParent = loadFXML(ViewFile.TEST);

        Scene testScene = new Scene(testViewParent);

        UniqueController testController = getController();
        testController.initData(fileList);

        Stage window = getStage(event);
        window.setScene(testScene);
        window.show();
    }



}
