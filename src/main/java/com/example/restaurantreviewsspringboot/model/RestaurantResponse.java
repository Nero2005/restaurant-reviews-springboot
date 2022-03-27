package com.example.restaurantreviewsspringboot.model;

import java.util.List;
import java.util.Map;

public class RestaurantResponse {
    private List<Restaurant> restaurants;
    private Integer page;
    private Map<String, String> filters;
    private Integer entries_per_page;
    private Integer total_results;

    public RestaurantResponse() {}

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    public Integer getEntries_per_page() {
        return entries_per_page;
    }

    public void setEntries_per_page(Integer entries_per_page) {
        this.entries_per_page = entries_per_page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}
