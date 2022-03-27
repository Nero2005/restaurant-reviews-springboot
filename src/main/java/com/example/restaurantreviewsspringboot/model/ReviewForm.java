package com.example.restaurantreviewsspringboot.model;

public class ReviewForm {
    private String name;
    private String text;
    private String user_id;
    private Integer restaurant_id;

    public ReviewForm(String name, String text, String user_id, Integer restaurant_id) {
        this.name = name;
        this.text = text;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
