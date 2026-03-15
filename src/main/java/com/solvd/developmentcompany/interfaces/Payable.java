package com.solvd.developmentcompany.interfaces;

public interface Payable {
    double calculateTotalCost();
    void processPayment(double amount);
    double getRemainingBalance();
}
