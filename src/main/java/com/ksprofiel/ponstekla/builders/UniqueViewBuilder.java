package com.ksprofiel.ponstekla.builders;

import com.ksprofiel.ponstekla.models.Contour;
import com.ksprofiel.ponstekla.models.Hole;
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
        //createContours();
        gridPane.setHgap(20);
        gridPane.setVgap(15);
    }
    private void createHoles(){
        gridPane.add(headLabel("Holes"),column,0,SIZE_GRIDPANE,SIZE_GRIDPANE);
        column++;
        for (Hole hole: holeSet) {
            gridPane.add(new Label(hole.getSide()),0,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(hole.getY())),2,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(hole.getSize())),3,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new TextField(),4,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            column++;
        }
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
