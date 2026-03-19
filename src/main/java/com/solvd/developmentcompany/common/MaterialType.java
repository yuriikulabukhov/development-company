package com.solvd.developmentcompany.common;

public enum MaterialType {
    CONCRETE("Concrete", 150.0, "Foundation material"),
    STEEL("Steel", 800.0, "Foundation reinforcement"),
    BRICK("Brick", 50.0, "Wall material"),
    WOOD("Wood", 30.0, "Roof Material"),
    GLASS("Glass", 200.0, "Windows");

    private final String name;
    private final Double costPerItem;
    private final String description;

    MaterialType(String name, double costPerItem, String description) {
        this.name = name;
        this.costPerItem = costPerItem;
        this.description = description;
    }

    public double calculateCost(double quantity) {
        return costPerItem * quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
