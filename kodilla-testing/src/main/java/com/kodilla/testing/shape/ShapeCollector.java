package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes;

    public ShapeCollector() {
        this.shapes = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigure() {
        StringBuilder result = new StringBuilder();
        for (Shape shape : shapes) {
            result.append(shape.getShapeName()).append(", ");
        }
        // Usuń przecinek na końcu, jeśli istnieje
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}