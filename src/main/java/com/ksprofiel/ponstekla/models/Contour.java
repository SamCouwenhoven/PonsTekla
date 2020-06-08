package com.ksprofiel.ponstekla.models;

public class Contour {
    private String side;
    private double start;
    private double length;
    private double height;
    private double beginning;
    private double end;

    public Contour(double beginning,double end,double height,double length,String side)
    {
        if (beginning < end)
        {
            this.beginning = beginning;
            this.end = end;
        }
        else
        {
            this.beginning = end;
            this.end = beginning;
        }

        this.side = side;
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
