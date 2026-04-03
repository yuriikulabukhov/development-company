package com.solvd.developmentcompany.building;

import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.interfaces.Buildable;
import com.solvd.developmentcompany.interfaces.Measurable;
import java.util.Objects;

public abstract class Building implements Buildable, Measurable {
    private BuildingPlan plan;
    private Address address;
    private Boolean built;

    public Building() {}

    public Building(BuildingPlan plan, Address address, boolean built) {
        this.plan = plan;
        this.address = address;
        this.built = built;
    }

    @Override
    public void build() {}

    @Override
    public boolean isCompleted() {return built;}

    @Override
    public double getArea() {return plan != null ? plan.getArea() : 0.0;}

    @Override
    public double getVolume() {return getArea() * 3.0;}

    @Override
    public String getDimensions() {
        return "Area: " + getArea() + " sq.m, Rooms: " + (plan != null ? plan.getRooms() : 0);}

    public BuildingPlan getPlan() {return plan;}
    public void setPlan(BuildingPlan plan) {this.plan = plan;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public void markAsBuilt() {built = true;}

    public boolean isBuilt() {return built;}

    public abstract String getBuildingType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        if (this.hashCode() != building.hashCode()) return false;
        return Objects.equals(plan, building.plan)
                && Objects.equals(address, building.address)
                && Objects.equals(built, building.built);
    }
    @Override
    public int hashCode() {return Objects.hash(plan, address, built);}

}
