package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private String taskName;
    private String wantToBuy;
    private double quantity;
    private boolean taseExecuted;

    public ShoppingTask(String taskName, String wantToBuy, double quantity) {
        this.taskName = taskName;
        this.wantToBuy = wantToBuy;
        this.quantity = quantity;
        this.taseExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Wykonanie zadania ShoppingTask");
        taseExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecute() {
        return taseExecuted;
    }
}
