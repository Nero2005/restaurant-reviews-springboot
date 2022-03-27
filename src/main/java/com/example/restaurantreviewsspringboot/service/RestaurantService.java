package com.example.restaurantreviewsspringboot.service;

import com.example.restaurantreviewsspringboot.model.Restaurant;
import com.example.restaurantreviewsspringboot.model.RestaurantResponse;
import com.example.restaurantreviewsspringboot.repo.RestaurantRepo;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    RestaurantResponse getAllRestaurants(Integer page, Integer num, Map<String, String> filters);
    List<String> getAllCuisines();
    Restaurant getRestaurantById(Integer id);
    Restaurant updateRestaurant(Integer id, Restaurant newRestaurant);
}
