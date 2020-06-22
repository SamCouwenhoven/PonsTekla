package com.ksprofiel.ponstekla.builders;

import com.ksprofiel.ponstekla.models.Contour;
import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.Regex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
import java.util.Set;

public class UniqueViewBuilder {
    private static int column = 1;
    private static final int SIZE_GRIDPANE = 1;
    private GridPane gridPane;
    private Set<Hole> holeSet;
    private Set<Contour> contourSet;

    public UniqueViewBuilder(GridPane gridPane){
        this.gridPane = gridPane;

    }

    public void init(){
        createHoles();
        gridPane.setHgap(20);
        gridPane.setVgap(15);
    }
    private void createHoles(){
        addToGridpane(headLabel("Holes"),column);
        column++;
        for (Hole hole: holeSet) {
            addHoleToGridpane(hole);
            column++;
        }
    }

    private void addHoleToGridpane(Hole hole){

        Label sideLabel = new Label();
        sideLabel.setText(hole.getSide());
        sideLabel.setId(column + " sideLabel");

        Label yLabel = new Label();
        yLabel.setText(Double.toString( hole.getY() ));
        yLabel.setId(column + " yLabel");

        Label sizeLabel = new Label();
        sizeLabel.setText(Double.toString( hole.getSize() ));
        sizeLabel.setId(column + " sizeLabel");

        TextField uNrText = new TextField();
        uNrText.setId(column + " uNrText");

        uNrText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches(Regex.ANY_NUMBER)) {
                    uNrText.setText(newValue.replaceAll(Regex.NOT_NUMBER, ""));
                }
            }
        });



        addToGridpane(sideLabel,0);
        addToGridpane(yLabel,2);
        addToGridpane(sizeLabel,3);
        addToGridpane(uNrText,4);

    }

    private void addToGridpane(Control control,int i){
        gridPane.add(control,i,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
    }

    private void createContours(){
        gridPane.add(headLabel("Contours"),0,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
        column++;
        for (Contour contour: contourSet) {
            gridPane.add(new Label(contour.getSide()),0,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(contour.getLength())),2,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(contour.getHeight())),3,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new TextField(),4,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            column++;
        }
    }

    public void setHoleSet(Set<Hole> holeSet) {
        this.holeSet = holeSet;
    }

    public void setContourSet(Set<Contour> contourSet) {
        this.contourSet = contourSet;
    }

    private Label headLabel(String title){
        Label headLabel = new Label(title);
        return headLabel;
    }

}
