package com.workintech.library;

import java.util.Objects;

public class Address {
    private String city;
    private String region;
    private String street;
    private int apartmentNumber;

    public Address(String city, String region, String street, int apartmentNumber) {
        this.city = city;
        this.region = region;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return apartmentNumber == address.apartmentNumber && Objects.equals(city, address.city) && Objects.equals(region, address.region) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, region, street, apartmentNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
