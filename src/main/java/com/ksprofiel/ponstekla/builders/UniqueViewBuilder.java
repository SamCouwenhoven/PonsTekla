package com.ksprofiel.ponstekla.builders;

import com.ksprofiel.ponstekla.models.Hole;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

public class UniqueViewBuilder {
    private static final int SIZE_GRIDPANE = 1;
    private GridPane gridPane;
    private LinkedList<Hole> uniqueHoleList;

    public UniqueViewBuilder(GridPane gridPane){
        this.gridPane = gridPane;

    }

    public void init(){
        createHoles();
        gridPane.setHgap(20);
        gridPane.setVgap(15);
    }
    private void createHoles(){
        gridPane.add(headLabel("Holes"),0,0,SIZE_GRIDPANE,SIZE_GRIDPANE);
        int column = 1;
        for (Hole hole:uniqueHoleList) {
            gridPane.add(new Label(hole.getSide()),0,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(hole.getY())),2,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new Label(Double.toString(hole.getSize())),3,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            gridPane.add(new TextField(),4,column,SIZE_GRIDPANE,SIZE_GRIDPANE);
            column++;
        }
    }

    public void setUniqueHoleList(LinkedList<Hole> uniqueHoleList) {
        this.uniqueHoleList = uniqueHoleList;
    }

    private Label headLabel(String title){
        Label headLabel = new Label(title);
        return headLabel;
    }
}
