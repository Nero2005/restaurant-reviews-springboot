package com.example.restaurantreviewsspringboot.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String building;
    private Double latitude;
    private Double longitude;
    private String street;
    private String zipcode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Restaurant restaurant;

    public Address() {}

    public Address(String building, Double latitude, Double longitude, String street, String zipcode) {
        this.building = building;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
