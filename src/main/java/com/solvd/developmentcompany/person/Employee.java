package com.solvd.developmentcompany.person;

import com.solvd.developmentcompany.common.Address;
import com.solvd.developmentcompany.interfaces.Serviceable;
import com.solvd.developmentcompany.common.SkillLevel;

public abstract class Employee extends Person implements Serviceable {
    private Integer employeeId;
    private Double salary;
    private Integer yearsExperience;

    public Employee() {}

    public Employee(String firstName, String lastName, Integer age, Address address, String contactInfo,
                    Integer employeeId, Double salary, Integer yearsExperience) {
        super(firstName, lastName, age, address, contactInfo);
        this.employeeId = employeeId;
        this.salary = salary;
        this.yearsExperience = yearsExperience;
    }

    public Integer getEmployeeId() {return employeeId;}
    public void setEmployeeId(Integer employeeId) {this.employeeId = employeeId;}

    public Double getSalary() {return salary;}
    public void setSalary(Double salary) {this.salary = salary;}

    public Integer getYearsExperience() {return yearsExperience;}
    public void setYearsExperience(Integer yearsExperience) {this.yearsExperience = yearsExperience;}

    public abstract void work();

    public abstract String getRole();

    @Override
    public abstract String performService();

    @Override
    public double calculateServiceCost() {return salary;}

    @Override
    public boolean isAvailable() {return true;}



}
