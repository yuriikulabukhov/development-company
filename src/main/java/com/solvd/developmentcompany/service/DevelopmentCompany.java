package com.solvd.developmentcompany.service;

import com.solvd.developmentcompany.building.*;
import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.construction.ConstructionPhase;
import com.solvd.developmentcompany.exceptions.BudgetExceededException;
import com.solvd.developmentcompany.exceptions.InvalidAddressException;
import com.solvd.developmentcompany.exceptions.InvalidPermitException;
import com.solvd.developmentcompany.exceptions.ProjectNotApprovedException;
import com.solvd.developmentcompany.project.Project;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevelopmentCompany {
    private String name;
    private Address address;
    private List<Project> activeProjects;
    private static final Logger LOGGER = LoggerFactory.getLogger(DevelopmentCompany.class);


    public DevelopmentCompany() {}

    public DevelopmentCompany(String name, Address address,List<Project> activeProjects) {
        this.name = name;
        this.address = address;
        this.activeProjects = new ArrayList<>();
    }

    public Building buildHouse(Project project)
            throws InvalidPermitException, InvalidAddressException, BudgetExceededException {

        LOGGER.info("\n[" + name + "] Starting project: " + project.getName());

        validateProject(project);
        executePhases(project);
        Building building = createBuilding(project);
        building.markAsBuilt();

        LOGGER.info("[" + name + "] Done! " + building.getBuildingType()
                + " built at " + project.getLocation().getFullAddress());
        return building;
    }

    private void validateProject(Project project)
            throws InvalidPermitException, InvalidAddressException, BudgetExceededException {

        project.validatePermit();
        project.validateLocation();
        project.checkBudget(50000.0);

        if (!project.isApproved()) {
            throw new ProjectNotApprovedException("Project " + project.getName() + " is not approved."); }

        LOGGER.debug(" All passed.");
    }

    private void executePhases(Project project) {
        ConstructionPhase[] phases = project.getPhases();
        if (phases == null) {
            LOGGER.warn(" No Phases defined! ");
            return;
        }
        for (ConstructionPhase phase : phases) {
            LOGGER.debug(" Phase: " + phase.getName());
            phase.build();
        }
    }

    private Building createBuilding(Project project) {
        BuildingPlan plan = project.getPlan();
        Address location = project.getLocation();
        String type = project.getBuildingType();

        switch (type) {
            case "TownHouse":
                return new TownHouse(plan, location, false, true, 4);
            case "Office":
                return new Office(plan, location, false,  20, true, 3);
            case "Villa":
            default:
                return new Villa(plan, location, false, false, 150.0, true);
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Project> getActiveProjects() { return activeProjects; }
    public void addProject(Project project) { activeProjects.add(project); }
    public void removeProject(Project project) { activeProjects.remove(project); }

    @Override
    public String toString() {
        return "DevelopmentCompany{name='" + name + "'}";
    }
}