package com.example.restaurantreviewsspringboot.repo;


import com.example.restaurantreviewsspringboot.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    @Query(value = "SELECT DISTINCT cuisine FROM restaurants",
            nativeQuery = true)
    Collection<String> getAllCuisines();
}
