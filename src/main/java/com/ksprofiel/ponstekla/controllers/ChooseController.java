package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.models.ExtensionFilter;
import com.ksprofiel.ponstekla.models.ReadFile;
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

import java.io.File;
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

        addExtensionFilter(fileChooser);

        List<File> chosenFiles = fileChooser.showOpenMultipleDialog(getStage(event));

        if (chosenFiles != null) {
            fileList.addAll(chosenFiles);
            updateListView();
        }

    }

    private void addExtensionFilter(FileChooser fileChooser){
        for (ExtensionFilter filter:ExtensionFilter.values()) {
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(filter.getText(), filter.getExtension());
            fileChooser.getExtensionFilters().add(extensionFilter);
        }
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
        readFileListView.getItems().addAll( ReadFile.toList(fileToRead) );
    }

    @FXML
    private void removeSelectedFiles(){
        ObservableList<File> filesToRemove = fileListView.getSelectionModel().getSelectedItems();
        fileList.removeAll(filesToRemove);
        updateListView();
    }

    @FXML
    private void toNextView(ActionEvent event){
        Parent uniqueViewParent = loadFXML(ViewFile.TEST);

        Scene uniqueScene = new Scene(uniqueViewParent);

        UniqueController uniqueController = getController();
        uniqueController.initData(fileList);

        Stage window = getStage(event);
        window.setScene(uniqueScene);
        window.show();
    }



}
