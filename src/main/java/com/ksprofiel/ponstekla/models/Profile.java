package com.ksprofiel.ponstekla.models;

import java.io.File;
import java.util.LinkedList;

import static com.ksprofiel.ponstekla.models.Regex.addUniques;

public class Profile {

    private String name;
    private double length;
    private LinkedList<Contour> contourIK;
    private LinkedList<Contour> contourAK;
    private LinkedList<Hole> holes;

    public void setHoles(LinkedList<Hole> holes) {
        this.holes = holes;
    }

    public LinkedList<Hole> getHoles() {
        return holes;
    }
}
