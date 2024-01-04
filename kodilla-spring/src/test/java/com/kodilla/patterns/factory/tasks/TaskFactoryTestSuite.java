package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);

        //Then
        assertEquals("Zakupy", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecute());
    }
    @Test
    void testPaintingTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);

        // Then
        assertEquals("Malowanie", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecute());
    }
    @Test
    void testDrivingTask() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);

        // Then
        assertEquals("Jazda", drivingTask.getTaskName());
        assertFalse(drivingTask.isTaskExecute());
    }
}
