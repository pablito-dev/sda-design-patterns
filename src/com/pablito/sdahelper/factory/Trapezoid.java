package com.pablito.sdahelper.factory;

public class Trapezoid extends Shape {
    private final int height;
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public Trapezoid(final int height, final int a, final int b, final int c, final int d) {
        this.height = height;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return ((a + b) / 2) * height;
    }

    @Override
    public double circumference() {
        return a + b + c + d;
    }
}
