package com.ksprofiel.ponstekla.models;

public class LongHole extends Hole {

    private double length;

    public LongHole(String side, double x, double y, double size, double length) {
        super(side, x, y, size);
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            LongHole longHole = (LongHole) o;
            return longHole.length == length;
        }
        return false;
    }
}
