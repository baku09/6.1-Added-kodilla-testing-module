package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPINGTASK = "SHOPPING TASK";
    public static final String PAINTINGTASK = "PAINTING TASK";
    public static final String DRIVINGTASK = "DRIVING TASK";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPINGTASK -> new ShoppingTask("Zakupy", "Mleko", 5);
            case PAINTINGTASK -> new PaintingTask("Malowanie", "czerwony", "samochód");
            case DRIVINGTASK ->  new DrivingTask("Jazda", "Berlin", "Auto");
            default -> null;
        };
    }
}
