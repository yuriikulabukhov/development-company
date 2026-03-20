package com.solvd.developmentcompany.person;

import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.interfaces.Payable;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer extends Person implements Payable {
    private Integer customerId;
    private Double accountBalance;
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    public Customer() {}

    public Customer(String firstName, String lastName, Integer age, Address address, String contactInfo,
                    Integer customerId, Double accountBalance) {
        super(firstName, lastName, age, address, contactInfo);
        this.customerId = customerId;
        this.accountBalance = accountBalance;
    }

    public Integer getCustomerId() {return customerId;}
    public void setCustomerId(Integer customerId) {this.customerId = customerId;}

    public Double getAccountBalance() {return accountBalance;}
    public void setAccountBalance(Double accountBalance) {this.accountBalance = accountBalance;}

    @Override
    public String getDescription() {
        return "Customer: " + getFullName() + ",ID: " + customerId + ",Balance: $" + accountBalance;
    }

    @Override
    public String getRole() {return "Property Customer";
    }

    @Override
    public double calculateTotalCost() {
        return 0;}

    @Override
    public void processPayment(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            LOGGER.info("Payment processed: $" + amount);
        } else {
            LOGGER.warn("Insufficient balance!");
        }
    }

    @Override
    public double getRemainingBalance() {
        return accountBalance;
    }

}
