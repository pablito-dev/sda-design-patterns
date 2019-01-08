package com.pablito.sdahelper.factory;

public final class ShapeFactory {
    private ShapeFactory() {
    }

    public static Shape buildShape(final String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(3);
        } else if (shapeType.equalsIgnoreCase("TRAPEZOID")) {
            return new Trapezoid(1, 2, 3, 4, 5);
        } else {
            return null;
        }
    }
}
