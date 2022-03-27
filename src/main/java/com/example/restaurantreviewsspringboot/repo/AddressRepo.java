package com.example.restaurantreviewsspringboot.repo;

import com.example.restaurantreviewsspringboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
