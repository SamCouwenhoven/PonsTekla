package com.ksprofiel.ponstekla.models;

public class Contour {
    private String side;
    private double length;
    private double height;

    public Contour(double height,double length,String side)
    {
        this.height = height;
        this.length = length;
        this.side = side;
    }

    public String getSide() {
        return side;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Contour contour = (Contour) o;
        return side.equals(contour.side) &&
                length == contour.length &&
                height == contour.height;
    }
}
