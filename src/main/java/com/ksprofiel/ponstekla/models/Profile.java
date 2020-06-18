package com.ksprofiel.ponstekla.models;

import java.util.LinkedList;
import java.util.List;

public class Profile {

    private String name;
    private double length;
    private List<Contour> contourIK;
    private List<Contour> contourAK;
    private List<Hole> holes;

    public void setContourAK(LinkedList<Contour> contourAK) {
        this.contourAK = contourAK;
    }

    public List<Contour> getContourAK() {
        return contourAK;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
