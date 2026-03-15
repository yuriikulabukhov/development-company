package com.solvd.developmentcompany.person;

import com.solvd.developmentcompany.common.Address;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engineer extends Employee {
    private String specialization;
    private Boolean isLicensed;
    private static final Logger LOGGER = LoggerFactory.getLogger(Engineer.class);

    public Engineer() {}

    public Engineer(String firstName, String lastName, Integer age, Address address, String contactInfo,
                    Integer employeeId, Double salary, Integer yearsExperience, String specialization, Boolean isLicensed) {
        super(firstName, lastName, age, address, contactInfo, employeeId, salary, yearsExperience);
        this.specialization = specialization;
        this.isLicensed = isLicensed;
    }

    @Override
    public void work() {
        LOGGER.info("Engineer " + getFullName() + " performs structural calculations and technical analysis");
    }

    @Override
    public String getDescription() {
        return " Engineer: " + getFullName() + " Specialization: " + specialization +
                " Licensed: " + (isLicensed ? "Yes" : "No") +
                " Experience: " + getYearsExperience() + " years";
    }

    @Override
    public String getRole() {return "Structural Engineer";}

    @Override
    public String performService() {return "Engineering and structural calculations performed by " + getFullName();}

    @Override
    public double calculateServiceCost() {
        double baseCost = super.calculateServiceCost();
        return isLicensed ? baseCost * 1.4 : baseCost;
    }

    @Override
    public String toString() {
        return "Engineer{" + "specialization='" + specialization + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(specialization, engineer.specialization) &&
                Objects.equals(isLicensed, engineer.isLicensed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization, isLicensed);
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Boolean getLicensed() {
        return isLicensed;
    }
    public void setLicensed(Boolean licensed) {
        isLicensed = licensed;
    }
}
