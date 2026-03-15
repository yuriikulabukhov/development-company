package com.solvd.developmentcompany.project;

import com.solvd.developmentcompany.interfaces.Payable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Budget implements Payable {
    private Double totalBudget;
    private Double spent;
    private static final Logger LOGGER = LoggerFactory.getLogger(Budget.class);
    private static Integer budgetCounter = 0;


    public Budget() {
        this.totalBudget = 0.0;
        this.spent = 0.0;
        budgetCounter++;
    }

    public Budget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.spent = 0.0;
        budgetCounter++;
    }

    public void spend(double amount) {
        if (spent + amount <= totalBudget) {
            spent += amount;
            LOGGER.info("Spent: $" + amount + ". Remaining: $" + getRemaining());
        } else {
            LOGGER.error("Budget exceeded! Cannot spend $" + amount);
        }
    }
    static {
        LOGGER.debug("Budget class loaded");
        budgetCounter = 0;
    }
    public double getRemaining() {
        return totalBudget - spent;
    }

    @Override
    public double calculateTotalCost() {
        return totalBudget;
    }

    @Override
    public void processPayment(double amount) {
        spend(amount);
    }

    @Override
    public double getRemainingBalance() {
        return getRemaining();
    }

    public Double getTotalBudget() {
        return totalBudget;
    }
    public void setTotalBudget(Double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Double getSpent() {
        return spent;
    }
    public void setSpent(Double spent) {this.spent = spent;}

    public static Integer getBudgetCounter() {
        return budgetCounter;
    }
}
