package com.ksprofiel.ponstekla.controllers;

import com.ksprofiel.ponstekla.models.ViewFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooseController extends AbstractController{
    @FXML
    private Button addButton;

    @FXML
    private void print(ActionEvent event){
        Parent testViewParent = loadFXML(ViewFile.TEST);

        Scene testScene = new Scene(testViewParent);

        TestController testController = getController();
        testController.initData("Super mooie message incomming");

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(testScene);
        window.show();


    }

}
