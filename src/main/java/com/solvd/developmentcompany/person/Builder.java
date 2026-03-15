package com.solvd.developmentcompany.person;

import com.solvd.developmentcompany.common.Address;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Builder extends Employee {
    private String skillLevel;
    private Boolean isCertified;
    private static final Logger LOGGER = LoggerFactory.getLogger(Builder.class);

    public Builder() {}

    public Builder(String firstName, String lastName, Integer age, Address address, String contactInfo,
                   Integer employeeId, Double salary, Integer yearsExperience, String skillLevel, Boolean isCertified) {
        super(firstName, lastName, age, address, contactInfo, employeeId, salary, yearsExperience);
        this.skillLevel = skillLevel;
        this.isCertified = isCertified;
    }
    public String getSkillLevel() {return skillLevel;}

    public void setSkillLevel(String skillLevel) {this.skillLevel = skillLevel;}

    public Boolean getCertified() {return isCertified;}

    public void setCertified(Boolean certified) {isCertified = certified;}

    @Override
    public void work() {
        LOGGER.info("Builder " + getFullName() + "performs manual work");
    }

    @Override
    public String getDescription() {
        return "Builder: " + getFullName() +
                ", Level: " + skillLevel +
                ", Experience: " + getYearsExperience() + " years" +
                ", Certified: " + (isCertified ? "Yes" : "No");
    }

    @Override
    public String getRole() {
        return "Construction Builder";
    }

    @Override
    public String performService() {
        return "Building and constructing performed by " + getFullName();
    }

    @Override
    public double calculateServiceCost() {
        double baseCost = super.calculateServiceCost();
        return isCertified ? baseCost * 1.3 : baseCost;
    }

    @Override
    public String toString() {
        return "Builder " +
                " employeeId :" + getEmployeeId() +
                " name :" + getFullName() + '\'' +
                " skillLevel :" + skillLevel + '\'' +
                " isCertified :" + isCertified +
                " yearsExperience :" + getYearsExperience() + " years";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFirstName(), getLastName(), skillLevel, isCertified);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Builder builder = (Builder) obj;
        return Objects.equals(getEmployeeId(), builder.getEmployeeId()) &&
                Objects.equals(skillLevel, builder.skillLevel) &&
                Objects.equals(isCertified, builder.isCertified);
    }

}
