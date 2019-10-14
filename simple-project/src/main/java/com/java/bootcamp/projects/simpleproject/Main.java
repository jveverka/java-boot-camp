package com.java.bootcamp.projects.simpleproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("main started ...");
        Shape circleShape = new Circle(10, "mm");
        Shape squareShape = new Square(10, "cm");
        LOG.info("Circle area={}", circleShape.getArea());
        LOG.info("Square area={}", squareShape.getArea());
        LOG.info("done.");
    }

}
