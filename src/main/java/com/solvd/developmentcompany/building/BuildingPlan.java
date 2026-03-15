package com.solvd.developmentcompany.building;

public class BuildingPlan {
    private Integer floors;
    private Integer rooms;
    private Integer bathrooms;
    private Double area;
    private String style;

    public BuildingPlan() {}

    public BuildingPlan(Integer floors, Integer rooms, Integer bathrooms, Double area, String style) {
        this.floors = floors;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.area = area;
        this.style = style;
    }

    public Integer getFloors() {return floors; }
    public void setFloors(Integer floors) {this.floors = floors;}

    public Integer getRooms() {return rooms;}
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }

    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
}
