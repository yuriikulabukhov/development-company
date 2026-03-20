package com.solvd.developmentcompany.building;

import com.solvd.developmentcompany.common.Address;
import java.util.Objects;

public class TownHouse extends Building {
    private Boolean hasParking;
    private Integer houseUnits;

    public TownHouse() {}

    public TownHouse(BuildingPlan plan, Address address, Boolean built,
                     Boolean hasParking, Integer houseUnits) {
        super(plan, address, built);
        this.hasParking = hasParking;
        this.houseUnits = houseUnits;
    }

    @Override
    public String getBuildingType() {
        return " TownHouse ";
    }

    @Override
    public String getDimensions() {
        return super.getDimensions() + " Attached units: " + houseUnits;
    }

    public Boolean getHasParking() {
        return hasParking;
    }
    public void setHasParking(Boolean hasParklot) {
        this.hasParking = hasParklot;
    }

    public Integer getHouseUnits() {
        return houseUnits;
    }
    public void setHouseUnits(Integer houseUnits) {
        this.houseUnits = houseUnits;
    }

    @Override
    public String toString() {
        return "TownHouse{units=" + houseUnits + ", hasParking=" + hasParking +
                ", " + getDimensions() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TownHouse that = (TownHouse) o;
        return Objects.equals(houseUnits, that.houseUnits) &&
                Objects.equals(hasParking, that.hasParking);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), houseUnits, hasParking);}

}
