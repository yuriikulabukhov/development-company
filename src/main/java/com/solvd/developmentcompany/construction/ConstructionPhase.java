package com.solvd.developmentcompany.construction;

import com.solvd.developmentcompany.interfaces.Buildable;

public abstract class ConstructionPhase implements Buildable {
    private String name;
    private Boolean completed;
    private Double completionPercentage;

    public ConstructionPhase() {}

    public ConstructionPhase(String name, Boolean completed, Double completionPercentage) {
        this.name = name;
        this.completed = completed != null ? completed : false;
        this.completionPercentage = completionPercentage != null ? completionPercentage : 0.0;
    }

    public abstract void execute();

    @Override
    public void build() {
        execute();
        this.completed = true;
        this.completionPercentage = 100.0;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
        this.completionPercentage = 100.0;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }

    public Double getCompletionPercentage() { return completionPercentage;}
    public void setCompletionPercentage(Double completionPercentage) { this.completionPercentage = completionPercentage;}
}
