package com.solvd.developmentcompany.main;

import com.solvd.developmentcompany.building.Building;
import com.solvd.developmentcompany.building.BuildingPlan;
import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.construction.ConstructionPhase;
import com.solvd.developmentcompany.construction.FoundationConstruction;
import com.solvd.developmentcompany.construction.RoofConstruction;
import com.solvd.developmentcompany.construction.WallConstruction;
import com.solvd.developmentcompany.exceptions.*;
import com.solvd.developmentcompany.interfaces.Serviceable;
import com.solvd.developmentcompany.person.*;
import com.solvd.developmentcompany.project.Budget;
import com.solvd.developmentcompany.project.Material;
import com.solvd.developmentcompany.project.Permit;
import com.solvd.developmentcompany.project.Project;
import com.solvd.developmentcompany.service.CollectionStreaming;
import com.solvd.developmentcompany.service.DevelopmentCompany;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {buildHouseForCustomer();}
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static void buildHouseForCustomer() {

        LOGGER.info("1.CUSTOMER REQUEST:");
        Address customerAddress = new Address("London", "secret Street", "221B");
        Customer customer = new Customer("James", "Bond", 45, customerAddress,
                                        "james.bond@mi6.com", 5001, 500000.0);
        LOGGER.info("Customer: " + customer.getFullName());
        LOGGER.info("Budget: $" + customer.getAccountBalance());

        LOGGER.info("2.CREATING TEAM");
        Person[] team = new Person[3];
        Address architectAddress = new Address("London", "Arch Street", "124B");
        team[0] = new Architect("Sarah", "Connor", 38, architectAddress,
                               "sarah@company.com", 2001, 8000.0, 12, "Modern", new ArrayList<String>());
        Address engineerAddress = new Address("London", "Eng Street", "125B");
        team[1] = new Engineer("John", "Smith", 42, engineerAddress,
                              "john@company.com", 2002, 7500.0, 15, "Structural", true);
        Address builderAddress = new Address("London", "Builders Street", "126B");
        team[2] = new Builder("Mike", "Tyson", 35, builderAddress,
                             "mike@company.com", 2003, 6000.0, 10, "Expert", true);

        LOGGER.info("Team created:");
        for (Person member : team) {
            LOGGER.info("  • " + member.getRole() + ": " + member.getFullName());
        }

        LOGGER.info("3.CALCULATING SERVICES");
        Serviceable[] serviceProviders = new Serviceable[3];
        serviceProviders[0] = (Architect) team[0];
        serviceProviders[1] = (Engineer) team[1];
        serviceProviders[2] = (Builder) team[2];

        double totalServiceCost = 0.0;
        for (Serviceable provider : serviceProviders) {
            LOGGER.info(provider.performService());
            double cost = provider.calculateServiceCost();
            LOGGER.info("  Cost: $" + cost);
            totalServiceCost += cost;}
        LOGGER.info("\nTotal service cost: $" + totalServiceCost);

        LOGGER.info("4.PLANNING THE BUILDING");
        Address address = new Address("London", "Green Str", "123");
        BuildingPlan plan = new BuildingPlan(2,5, 3, 250.0, "Luxury");

        LOGGER.info("Address: " + address.getFullAddress());
        LOGGER.info("Plan: " + plan.getRooms() + " rooms, " + plan.getBathrooms() +
                          " bathrooms, " + plan.getArea() + " sq.m");
        LOGGER.info("Style: " + plan.getStyle());


        LOGGER.info("5.PROJECT VALIDATION");
        try {
            Budget budget = new Budget(400000.0);
            LOGGER.info("Project budget allocated: $" + budget.getTotalBudget());

            Material concrete = new Material("Concrete", 50000.0);
            Material bricks = new Material("Bricks", 30000.0);
            Material roofing = new Material("Roofing", 25000.0);

            LOGGER.info("\nPurchasing materials:");
            purchaseMaterial(concrete, budget);
            purchaseMaterial(bricks, budget);
            purchaseMaterial(roofing, budget);


            Permit permit = new Permit("PERMIT-2026-001", true);

            LOGGER.info("\nPermit approved: " + permit.getPermitNumber());
            LOGGER.info("Valid for: " + permit.getMaxPeriod() + " days");

            ConstructionPhase[] phases = {
                    new FoundationConstruction("Foundation", false, 0.0, "Slab", 50.0,
                            new Material("Concrete", 50000.0), budget),
                    new WallConstruction("Walls", false, 0.0, "Brick",
                            200.0, new Material("Bricks", 30000.0), budget),
                    new RoofConstruction("Roof", false, 0.0, "Gable",
                            100.0, new Material("Roofing", 25000.0), budget)
            };

            Project project = new Project("Villa Bond", customer, address, plan, "Villa", phases, budget, permit);

            LOGGER.info("\n6.BUILDING THE PROJECT");
            project.approve();
            Address companyAddress = new Address("London", "Rich Street", "127");
            DevelopmentCompany company = new DevelopmentCompany("Build Construction Ltd", companyAddress, new ArrayList<>());
            Building house = company.buildHouse(project);

            LOGGER.info("\nBuilding Completed ");
            LOGGER.info("\nBuilding Details:");
            LOGGER.info("  Type: " + house.getBuildingType());
            LOGGER.info("  Status: " + (house.isBuilt() ? "Built ✓" : "Under Construction"));
            LOGGER.info("  Area: " + house.getArea() + " sq.m");
            LOGGER.info("\nFinancial Summary:");
            LOGGER.info("  Initial Budget: $" + budget.getTotalBudget());
            LOGGER.info("  Spent: $" + budget.getSpent());
            LOGGER.info("\nRemaining: $" + budget.getRemaining());


        } catch (MaterialShortageException | BudgetExceededException e) {
            LOGGER.error("Financial error: {}", e.getMessage(), e);
        } catch (InvalidPermitException | InvalidAddressException | ProjectNotApprovedException e) {
            LOGGER.error("Validation error: {}", e.getMessage(), e);
        }
        LOGGER.info("\n7. COLLECTION STREAMING");

        List<Employee> employees = List.of(
                (Employee) team[0],
                (Employee) team[1],
                (Employee) team[2]);

        List<Material> materials = List.of(
                new Material("Concrete", 50000.0),
                new Material("Bricks",   30000.0),
                new Material("Roofing",  25000.0),
                new Material("Steel",    80000.0),
                new Material("Woood",  15000.0) );

        CollectionStreaming.demonstrate(employees, materials);

        LOGGER.info("\n8. TEXT PARSER");
        try {
            TextParcer.run();
        } catch (IOException e) {
            LOGGER.error("File error: {}", e.getMessage());
        }

    }
    private static void purchaseMaterial(Material material, Budget budget) 
            throws MaterialShortageException {
        LOGGER.debug("  • " + material.getName() + ": $" + material.getCost());
        
        if (material.getCost() > budget.getRemaining()) {
            throw new MaterialShortageException(
                "Insufficient budget for " + material.getName() + 
                "Need: $" + material.getCost() +
                "Available: $" + budget.getRemaining()
            );
        }
        budget.spend(material.getCost());
    }

    private static void validateProject(Project project)
            throws InvalidPermitException, InvalidAddressException, BudgetExceededException {
        LOGGER.debug("Validating project...");
        project.validatePermit();
        LOGGER.debug("Permit valid");
        project.validateLocation();
        LOGGER.debug("Address valid");
        project.checkBudget(50000.0);
        LOGGER.debug("Budget sufficient");
    }

}
