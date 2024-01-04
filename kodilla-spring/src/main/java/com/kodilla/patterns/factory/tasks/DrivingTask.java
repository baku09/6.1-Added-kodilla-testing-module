package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private String taskName;
    private String where;
    private String using;
    private boolean taskExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.taskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Wykonano zadanie DrivingTask");
        taskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecute() {
        return taskExecuted;
    }
}
