package com.java.bootcamp.projects.simpleproject.tests;


import com.java.bootcamp.projects.simpleproject.Circle;
import com.java.bootcamp.projects.simpleproject.Shape;
import com.java.bootcamp.projects.simpleproject.Square;
import com.java.bootcamp.projects.simpleproject.Type;
import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

    @Test
    public void testShapes() {
        // Init variables
        String unit = "mm";
        double circleDiameter = 12;
        double squareSideLength = 12;

        // Test Circle implementation of Shape
        Shape circleShape = new Circle(circleDiameter, unit);
        Assert.assertEquals(Type.CIRCLE, circleShape.getType());
        Assert.assertTrue((Math.PI*((circleDiameter/2)*(circleDiameter/2))) == circleShape.getArea());
        Assert.assertTrue((2*Math.PI*(circleDiameter/2)) == circleShape.getCircumference());
        Assert.assertEquals(unit, circleShape.getUnit());
        Circle circle = (Circle)circleShape;
        Assert.assertTrue(circle.getDiameter() == circleDiameter);
        Assert.assertTrue(circle.getRadius() == circleDiameter/2);

        // Test Square implementation of Shape
        Shape squareShape = new Square(squareSideLength, unit);
        Assert.assertEquals(Type.SQUARE, squareShape.getType());
        Assert.assertEquals(unit, squareShape.getUnit());
        Assert.assertTrue(squareSideLength*squareSideLength == squareShape.getArea());
        Assert.assertTrue(4*squareSideLength == squareShape.getCircumference());
        Square square = (Square)squareShape;
        Assert.assertTrue(square.getSideLength() == squareSideLength);
    }

}
