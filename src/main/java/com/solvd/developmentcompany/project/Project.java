package com.solvd.developmentcompany.project;

import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.building.BuildingPlan;
import com.solvd.developmentcompany.construction.ConstructionPhase;
import com.solvd.developmentcompany.exceptions.*;
import com.solvd.developmentcompany.exceptions.BudgetExceededException;
import com.solvd.developmentcompany.exceptions.InvalidAddressException;
import com.solvd.developmentcompany.exceptions.InvalidPermitException;
import com.solvd.developmentcompany.interfaces.Approvable;
import com.solvd.developmentcompany.interfaces.Payable;
import com.solvd.developmentcompany.person.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Project implements Approvable, Payable {
    private String name;
    private Customer customer;
    private Address address;
    private BuildingPlan plan;
    private String buildingType;
    private ConstructionPhase[] phases;
    private Budget budget;
    private Permit permit;
    private Boolean approved;
    private static final Logger LOGGER = LoggerFactory.getLogger(Project.class);

    public Project() {}

    public Project(String name, Customer customer, Address address, BuildingPlan plan, String buildingType,
                   ConstructionPhase[] phases, Budget budget, Permit permit) {
        this.name = name;
        this.customer = customer;
        this.address = address;
        this.plan = plan;
        this.buildingType = buildingType;
        this.phases = phases;
        this.budget = budget;
        this.permit = permit;
        this.approved = false;;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public Address getLocation() {return address;}
    public void setLocation(Address address) {this.address = address;}

    public BuildingPlan getPlan() {return plan;}
    public void setPlan(BuildingPlan plan) {this.plan = plan;}

    public String getBuildingType() { return buildingType; }
    public void setBuildingType(String buildingType) { this.buildingType = buildingType; }

    public ConstructionPhase[] getPhases() {return phases;}
    public void setPhases(ConstructionPhase[] phases) {this.phases = phases;}

    public Budget getBudget() {return budget;}
    public void setBudget(Budget budget) {this.budget = budget;}

    public Permit getPermit() {return permit;}
    public void setPermit(Permit permit) {this.permit = permit;}

    public Boolean getApproved() {return approved;}
    public void setApproved(Boolean approved) {this.approved = approved;}

    @Override
    public void approve() {
        this.approved = true;
        LOGGER.info("Project " + name + " approved");
    }

    @Override
    public void reject() {
        this.approved = false;
        LOGGER.info("Project " + name + " rejected.");
    }

    @Override
    public boolean isApproved() {
        return approved != null && approved && permit != null && permit.isApproved();
    }

    @Override
    public String getApprovalStatus() {
        return isApproved() ? "Approved" : "Pending";
    }

    @Override
    public double calculateTotalCost() {
        return budget != null ? budget.getTotalBudget() : 0.0;
    }

    @Override
    public void processPayment(double amount) {
        if (budget != null) {
            budget.spend(amount);
        }
    }

    @Override
    public double getRemainingBalance() {
        return budget != null ? budget.getRemaining() : 0.0;
    }

    public void validatePermit() throws InvalidPermitException {
        if (permit == null || !permit.isApproved()) {
            throw new InvalidPermitException("Project cannot start: Permit not approved");
        }
    }

    public void checkBudget(double amount) throws BudgetExceededException {
        if (budget.getRemaining() < amount) {
            throw new BudgetExceededException("Insufficient budget: Need $" + amount + ", but only $" + budget.getRemaining() + " remaining");
        }
    }

    public void validateLocation() throws InvalidAddressException {
        if (address == null || address.getFullAddress() == null || address.getFullAddress().isEmpty()) {
            throw new InvalidAddressException("Invalid address: Can't be empty");
        }
    }

}
