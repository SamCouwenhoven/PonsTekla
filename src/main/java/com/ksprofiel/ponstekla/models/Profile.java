package com.ksprofiel.ponstekla.models;

import java.util.LinkedList;

public class Profile {

    private String name;
    private double length;
    private LinkedList<Contour> contourIK;
    private LinkedList<Contour> contourAK;
    private LinkedList<Hole> holes;

    public void setContourAK(LinkedList<Contour> contourAK) {
        this.contourAK = contourAK;
    }

    public LinkedList<Contour> getContourAK() {
        return contourAK;
    }

    public void setHoles(LinkedList<Hole> holes) {
        this.holes = holes;
    }

    public LinkedList<Hole> getHoles() {
        return holes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
