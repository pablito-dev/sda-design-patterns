package com.pablito.sdahelper.factory;

public class Circle extends Shape {
    private final int radius;

    public Circle(final int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double circumference() {
        return 2 * radius * Math.PI;
    }
}
