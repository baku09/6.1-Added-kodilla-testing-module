// src/test/java/com/kodilla/testing/shape/ShapeCollectorTestSuite.java
package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



@DisplayName("Tests for ShapeCollector")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for adding and removing figures")
    class AddAndRemoveFigures {

        @Test
        @DisplayName("Test adding a figure to the collection")
        void testAddFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(3);

            // When
            shapeCollector.addFigure(circle);

            // Then
            assertEquals("Circle",shapeCollector.showFigure());
        }

        @Test
        @DisplayName("Test removing a figure from the collection")
        void testRemoveFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(4, 5);
            shapeCollector.addFigure(triangle);

            // When
            shapeCollector.removeFigure(triangle);

            // Then
            assertEquals("", shapeCollector.showFigure());
        }
    }

    @Nested
    @DisplayName("Tests for getting figures")
    class GetFigures {

        @Test
        @DisplayName("Test getting a figure from the collection by index")
        void testGetFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(6);
            shapeCollector.addFigure(square);

            // When
            Shape retrievedFigure = shapeCollector.getFigure(0);

            // Then
            assertSame(square, retrievedFigure);
        }

        @Test
        @DisplayName("Test getting a figure from the empty collection")
        void testGetFigureFromEmptyCollection() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            Shape retrievedFigure = shapeCollector.getFigure(0);

            // Then
            assertNull(retrievedFigure);
        }

        @Test
        @DisplayName("Test getting a figure from the collection with an invalid index")
        void testGetFigureWithInvalidIndex() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(8);
            shapeCollector.addFigure(circle);

            // When
            Shape retrievedFigure = shapeCollector.getFigure(1);

            // Then
            assertNull(retrievedFigure);
        }
    }
}
