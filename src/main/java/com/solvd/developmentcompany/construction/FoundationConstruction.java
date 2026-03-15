package com.solvd.developmentcompany.construction;

import com.solvd.developmentcompany.project.Budget;
import com.solvd.developmentcompany.project.Material;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoundationConstruction extends ConstructionPhase {
    private String foundationType; // Pad, piles, trench (types)
    private Double concreteVolume;
    private Material materials;
    private Budget budget;
    private static final Logger LOGGER = LoggerFactory.getLogger(FoundationConstruction.class);

    public FoundationConstruction() {}

    public FoundationConstruction(String name, Boolean completed, Double completionPercentage,
                                  String foundationType, Double concreteVolume,
                                  Material materials, Budget budget) {
        super(name, completed, completionPercentage);
        this.foundationType = foundationType;
        this.concreteVolume = concreteVolume;
        this.materials = materials;
        this.budget = budget;
    }

    @Override
    public void execute() {
        LOGGER.info("Executing phase: " + getName() + ". Type: " + foundationType +
                ". Concrete needed: " + concreteVolume + "m3");
    }

    public String getFoundationType() { return foundationType; }
    public void setFoundationType(String foundationType) { this.foundationType = foundationType; }

    public Double getConcreteVolume() { return concreteVolume; }
    public void setConcreteVolume(Double concreteVolume) { this.concreteVolume = concreteVolume; }

    public Material getMaterials() { return materials; }
    public void setMaterials(Material materials) { this.materials = materials; }

    public Budget getBudget() { return budget; }
    public void setBudget(Budget budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "FoundationConstruction{" +
                "name='" + getName() + '\'' +
                ", foundationType='" + foundationType + '\'' +
                ", concreteVolume=" + concreteVolume +
                ", budget=" + budget +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoundationConstruction that = (FoundationConstruction) o;
        return Objects.equals(foundationType, that.foundationType) &&
                Objects.equals(concreteVolume, that.concreteVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundationType, concreteVolume);
    }
}
