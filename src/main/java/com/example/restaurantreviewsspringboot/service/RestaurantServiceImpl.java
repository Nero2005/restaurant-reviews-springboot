package com.example.restaurantreviewsspringboot.service;

import com.example.restaurantreviewsspringboot.model.Restaurant;
import com.example.restaurantreviewsspringboot.model.RestaurantResponse;
import com.example.restaurantreviewsspringboot.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }


    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public RestaurantResponse getAllRestaurants(Integer page, Integer num, Map<String, String> filters) {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        int size = restaurants.size();
        int end = Math.min(((page * num) + num), size);
        int start = Math.min((page * num), end);
        List<Restaurant> restaurantSubList = restaurants.subList(start, end);
        for (int i = 0; i < filters.keySet().size(); i++) {
            if (!filters.get("name").equals("")) {
                restaurantSubList = restaurantSubList.stream().filter(restaurant ->
                    restaurant.getName().toLowerCase().contains(filters.get("name").toLowerCase())
                ).collect(Collectors.toCollection(ArrayList::new));
            } else if(!filters.get("cuisine").equals("")) {
                restaurantSubList = restaurantSubList.stream().filter(restaurant ->
                        restaurant.getCuisine().equalsIgnoreCase(filters.get("cuisine").toLowerCase())
                ).collect(Collectors.toCollection(ArrayList::new));
            } else if (!filters.get("zipcode").equals("")) {
                restaurantSubList = restaurantSubList.stream().filter(restaurant ->
                        restaurant.getAddress().getZipcode()
                .equalsIgnoreCase(filters.get("zipcode").toLowerCase())
                ).collect(Collectors.toCollection(ArrayList::new));
            }
        }
        RestaurantResponse response = new RestaurantResponse();
        response.setRestaurants(restaurantSubList);
        response.setPage(page);
        response.setEntries_per_page(num);
        response.setFilters(filters);
        response.setTotal_results(restaurantSubList.size());
        return response;
    }

    @Override
    public List<String> getAllCuisines() {

        return (List<String>) restaurantRepo.getAllCuisines();
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {

        return restaurantRepo.findById(id).orElse(null);
    }

    @Override
    public Restaurant updateRestaurant(Integer id, Restaurant newRestaurant) {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setName(newRestaurant.getName());
        restaurant.setCuisine(newRestaurant.getCuisine());
        restaurant.setBorough(newRestaurant.getBorough());
        restaurant.setAddress(newRestaurant.getAddress());
        restaurantRepo.save(restaurant);
        return null;
    }
}
