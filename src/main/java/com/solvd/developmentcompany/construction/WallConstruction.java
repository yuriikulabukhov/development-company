package com.solvd.developmentcompany.construction;

import com.solvd.developmentcompany.project.Budget;
import com.solvd.developmentcompany.project.Material;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WallConstruction extends ConstructionPhase {
    private String wallType;
    private Double wallArea;
    private Material material;
    private Budget budget;
    private static final Logger LOGGER = LoggerFactory.getLogger(WallConstruction.class);


    public WallConstruction() {}

    public WallConstruction(String name, Boolean completed, Double completionPercentage,
                            String wallType, Double wallArea, Material material, Budget budget) {
        super(name, completed, completionPercentage);
        this.wallType = wallType;
        this.wallArea = wallArea;
        this.material = material;
        this.budget = budget;
    }

    @Override
    public void execute() {
        LOGGER.info("Executing phase: " + getName() + " Building walls and inner structures");
    }

    public String getWallType() { return wallType; }
    public void setWallType(String wallType) { this.wallType = wallType;}

    public Double getWallArea() { return wallArea; }
    public void setWallArea(Double wallArea) { this.wallArea = wallArea; }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { this.material = material; }

    public Budget getBudget() { return budget; }
    public void setBudget(Budget budget) { this.budget = budget;}

    @Override
    public String toString() {
        return "WallConstruction{" +
                "wallType='" + wallType + '\'' + ", wallArea=" + wallArea +
                ", material=" + material + ", budget=" + budget + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WallConstruction that = (WallConstruction) o;
        return Objects.equals(wallType, that.wallType) && Objects.equals(wallArea, that.wallArea) &&
                Objects.equals(material, that.material) && Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() { return Objects.hash(wallType, wallArea, material, budget);}
}
