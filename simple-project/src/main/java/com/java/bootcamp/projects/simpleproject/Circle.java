package com.java.bootcamp.projects.simpleproject;

public class Circle extends Shape {

    private final double diameter;

    public Circle(double diameter, String unit) {
        super(unit);
        this.diameter = diameter;
    }

    public Type getType() {
        return Type.CIRCLE;
    }

    public double getArea() {
        return Math.PI*((diameter/2)*(diameter/2));
    }

    public double getCircumference() {
        return 2*Math.PI*(diameter/2);
    }

    public double getDiameter() {
        return diameter;
    }

    public double getRadius() {
        return diameter/2;
    }

}
