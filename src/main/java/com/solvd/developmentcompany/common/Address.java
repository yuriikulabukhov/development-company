package com.solvd.developmentcompany.common;

public record Address(String city, String street, String house) {

    public String getFullAddress() {
        return street + ", " + house + ", " + city;
    }
}