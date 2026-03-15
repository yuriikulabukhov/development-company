package com.solvd.developmentcompany.building;

import com.solvd.developmentcompany.common.Address;
import java.util.Objects;

public class Villa extends Building {
    private Boolean hasPool;
    private Double gardenArea;
    private Boolean hasTerrace;

    public Villa() {}

    public Villa(BuildingPlan plan, Address address, boolean built,
                 boolean hasPool, double gardenArea, boolean hasTerrace) {
        super(plan, address, built);
        this.hasPool = hasPool;
        this.gardenArea = gardenArea;
        this.hasTerrace = hasTerrace;
    }

    @Override
    public String getBuildingType() {return "Villa";}

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public double getGardenArea() {
        return gardenArea;
    }

    public void setGardenArea(double gardenArea) {
        this.gardenArea = gardenArea;
    }

    public boolean isHasTerrace() {
        return hasTerrace;
    }

    public void setHasTerrace(boolean hasTerrace) {
        this.hasTerrace = hasTerrace;
    }

    @Override
    public String toString() {
        return "Villa{" + "hasPool=" + hasPool +
                ", gardenArea=" + gardenArea +
                ", hasTerrace=" + hasTerrace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Villa villa = (Villa) o;
        return hasPool == villa.hasPool &&
                hasTerrace == villa.hasTerrace &&
                Double.compare(villa.gardenArea, gardenArea) == 0 &&
                Objects.equals(getLocation(), villa.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), hasPool, gardenArea, hasTerrace);
    }
}