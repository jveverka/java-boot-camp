package com.java.bootcamp.projects.simpleproject;

public class Square extends Shape {

    private final double sideLength;

    public Square(double sideLength, String unit) {
        super(unit);
        this.sideLength = sideLength;
    }

    public Type getType() {
        return Type.SQUARE;
    }

    public double getArea() {
        return sideLength*sideLength;
    }

    public double getCircumference() {
        return 4*sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

}
