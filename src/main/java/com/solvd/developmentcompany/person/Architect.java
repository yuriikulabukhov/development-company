package com.solvd.developmentcompany.person;
import com.solvd.developmentcompany.common.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.solvd.developmentcompany.common.SkillLevel;

public class Architect extends Employee {
    private String designStyle;
    private List<String> completedProjects;
    private static final Logger LOGGER = LoggerFactory.getLogger(Architect.class);

    public Architect() {this.completedProjects = new ArrayList<>();}

    public Architect(String firstName, String lastName, Integer age, Address address, String contactInfo,
                     Integer employeeId, Double salary, Integer yearsExperience, String designStyle,
                     List<String> completedProjects) {
        super(firstName, lastName, age, address, contactInfo, employeeId, salary, yearsExperience);
        this.designStyle = designStyle;
        this.completedProjects = (completedProjects != null) ? completedProjects : new ArrayList<>();
    }
    public String getDesignStyle() {
        return designStyle;
    }
    public void setDesignStyle(String designStyle) {this.designStyle = designStyle;}

    public List<String> getCompletedProjects() { return completedProjects;}
    public void setCompletedProjects(List<String> completedProjects) {
        this.completedProjects = completedProjects; }

    @Override
    public void work() {
        LOGGER.info("Architect " + getFullName() + " designs building plans and architectural concepts");
    }

    @Override
    public String getDescription() {
        return "Architect: " + getFullName() +
                " Style: " + designStyle +
                " Projects: " + completedProjects.size() +
                " Experience: " + getYearsExperience() + " years";
    }

    @Override
    public String getRole() {
        return "Lead Architect";
    }

    @Override
    public String performService() {
        return "Architectural design and planning performed by" + getFullName();
    }

    @Override
    public double calculateServiceCost() {
        return super.calculateServiceCost() * (1 + (completedProjects.size() * 0.05));
    }

}
