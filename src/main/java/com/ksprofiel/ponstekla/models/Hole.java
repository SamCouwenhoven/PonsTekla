package com.ksprofiel.ponstekla.models;

public class Hole{
    private String side;
    private double x;
    private double y;
    private double size;

    public Hole(String side, double x, double y, double size){
        this.side = side;
        this.x = x;
        this.y = round(y);
        this.size = size;
    }

    public Hole(String[] dataLine){
        this(dataLine[1], Double.parseDouble(dataLine[2].substring(0,dataLine[2].length()-1)), Double.parseDouble(dataLine[3]), Double.parseDouble(dataLine[4]) );
    }

    private double round(double number){

        return ((double) Math.round(number*10)) / 10;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Hole hole = (Hole) o;
        return side.equals(hole.side) &&
                y == hole.y &&
                size == hole.size;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "side='" + side + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }

    public String getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize() {
        return size;
    }
}