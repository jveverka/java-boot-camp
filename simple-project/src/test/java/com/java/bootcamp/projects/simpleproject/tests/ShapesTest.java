package com.java.bootcamp.projects.simpleproject.tests;


import com.java.bootcamp.projects.simpleproject.Circle;
import com.java.bootcamp.projects.simpleproject.Shape;
import com.java.bootcamp.projects.simpleproject.Square;
import com.java.bootcamp.projects.simpleproject.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapesTest {

    @Test
    public void testShapes() {
        // Init variables
        String unit = "mm";
        double circleDiameter = 12;
        double squareSideLength = 12;

        // Test Circle implementation of Shape
        Shape circleShape = new Circle(circleDiameter, unit);
        assertEquals(Type.CIRCLE, circleShape.getType());
        assertTrue((Math.PI*((circleDiameter/2)*(circleDiameter/2))) == circleShape.getArea());
        assertTrue((2*Math.PI*(circleDiameter/2)) == circleShape.getCircumference());
        assertEquals(unit, circleShape.getUnit());
        Circle circle = (Circle)circleShape;
        assertTrue(circle.getDiameter() == circleDiameter);
        assertTrue(circle.getRadius() == circleDiameter/2);

        // Test Square implementation of Shape
        Shape squareShape = new Square(squareSideLength, unit);
        assertEquals(Type.SQUARE, squareShape.getType());
        assertEquals(unit, squareShape.getUnit());
        assertTrue(squareSideLength*squareSideLength == squareShape.getArea());
        assertTrue(4*squareSideLength == squareShape.getCircumference());
        Square square = (Square)squareShape;
        assertTrue(square.getSideLength() == squareSideLength);
    }

}
