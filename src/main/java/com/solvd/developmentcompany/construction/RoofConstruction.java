package com.solvd.developmentcompany.construction;

import com.solvd.developmentcompany.project.Budget;
import com.solvd.developmentcompany.project.Material;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoofConstruction extends ConstructionPhase {
    private String roofType;
    private Double roofArea;
    private Material material;
    private Budget budget;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoofConstruction.class);


    public RoofConstruction() {}

    public RoofConstruction(String name, Boolean completed, Double completionPercentage, String roofType, Double roofArea, Material material, Budget budget) {
        super(name, completed, completionPercentage);
        this.roofType = roofType;
        this.roofArea = roofArea;
        this.material = material;
        this.budget = budget;
    }
    @Override
    public void execute() {
        LOGGER.info("Executing phase: " + getName() + " Roof installation and finishing");
    }

    public String getRoofType() { return roofType; }
    public void setRoofType(String roofType) { this.roofType = roofType; }

    public Double getRoofArea() { return roofArea;}
    public void setRoofArea(Double roofArea) { this.roofArea = roofArea; }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { this.material = material; }

    public Budget getBudget() { return budget; }
    public void setBudget(Budget budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "RoofConstruction{" +
                "roofType='" + roofType + '\'' + ", roofArea=" + roofArea +
                ", material=" + material + ", budget=" + budget + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoofConstruction that = (RoofConstruction) o;
        return Objects.equals(roofType, that.roofType) && Objects.equals(roofArea, that.roofArea) &&
                Objects.equals(material, that.material) && Objects.equals(budget, that.budget);
    }
    @Override
    public int hashCode() {
        return Objects.hash(roofType, roofArea, material, budget);
    }
}
