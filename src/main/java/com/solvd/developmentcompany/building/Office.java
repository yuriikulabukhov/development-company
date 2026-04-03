package com.solvd.developmentcompany.building;

import com.solvd.developmentcompany.common.Address;
import java.util.Objects;

public class Office extends Building {
    private Integer numberOfOffices;
    private Boolean hasUndergroundParking;
    private Integer numberOfElevators;

    public Office() {}

    public Office(BuildingPlan plan, Address address, Boolean built,
                  Integer numberOfOffices, Boolean hasUndergroundParking, Integer numberOfElevators) {
        super(plan, address, built);
        this.numberOfOffices = numberOfOffices;
        this.hasUndergroundParking = hasUndergroundParking;
        this.numberOfElevators = numberOfElevators;
    }

    @Override
    public String getBuildingType() { return "Office"; }

    public Integer getNumberOfOffices() { return numberOfOffices; }
    public void setNumberOfOffices(Integer numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public Boolean getHasUndergroundParking() {
        return hasUndergroundParking;
    }
    public void setHasUndergroundParking(Boolean hasUndergroundParking) { this.hasUndergroundParking = hasUndergroundParking;}

    public Integer getNumberOfElevators() {
        return numberOfElevators;
    }
    public void setNumberOfElevators(Integer numberOfElevators) {
        this.numberOfElevators = numberOfElevators;
    }

    @Override
    public String toString() {
        return "Office{" + "numberOfOffices=" + numberOfOffices +
                ", hasUndergroundParking=" + hasUndergroundParking +
                ", numberOfElevators=" + numberOfElevators + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Office office = (Office) o;
        if (this.hashCode() != office.hashCode()) return false;
        return Objects.equals(numberOfOffices, office.numberOfOffices)
                && Objects.equals(hasUndergroundParking, office.hasUndergroundParking)
                && Objects.equals(numberOfElevators, office.numberOfElevators);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfOffices, hasUndergroundParking, numberOfElevators); }
}
