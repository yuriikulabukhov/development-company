package com.solvd.developmentcompany.project;

import com.solvd.developmentcompany.interfaces.ISearch;
import com.solvd.developmentcompany.interfaces.Payable;

import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Material implements Payable {
    private String name;
    private Double cost;
    private static final Logger LOGGER = LoggerFactory.getLogger(Material.class);

    public Material() {}

    public Material(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Double getCost() {return cost;}
    public void setCost(Double cost) {this.cost = cost;}

    @Override
    public double calculateTotalCost() {return cost;}

    @Override
    public void processPayment(double amount) {
        LOGGER.info("Payment for " + name + ": $" + amount);
    }
    @Override
    public double getRemainingBalance() {
        return 0.0;
    }

}
