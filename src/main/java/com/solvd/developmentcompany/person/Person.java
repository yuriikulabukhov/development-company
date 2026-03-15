package com.solvd.developmentcompany.person;

import com.solvd.developmentcompany.common.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Address address;
    private String contactInfo;
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    public Person() {}

    public Person(String firstName, String lastName, Integer age, Address address, String contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.contactInfo = contactInfo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void displayInfo() {
        System.out.println(getFullName());
    }

    public void displayInfo(boolean detailed) {
        if (detailed) {
            LOGGER.info(getDescription());
        } else {
            displayInfo();
        }
    }

    public void displayInfo(String prefix) {
        LOGGER.info(prefix + ": " + getFullName());

    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public abstract String getDescription();

    public abstract String getRole();
}
