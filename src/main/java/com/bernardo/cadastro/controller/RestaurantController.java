package com.bernardo.cadastro.controller;

import com.bernardo.cadastro.dto.RestaurantDto;
import com.bernardo.cadastro.model.Restaurant;
import com.bernardo.cadastro.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/insert")
    public ResponseEntity insertRestaurant(@RequestBody RestaurantDto restaurantDto){
        try {
            Restaurant restaurant = restaurantService.insertRestaurant(Restaurant.create(restaurantDto));
            return ResponseEntity.ok(restaurant);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurant(@RequestBody RestaurantDto restaurantDto, @PathVariable("id") Long id) {
        Restaurant restaurant = Restaurant.create(restaurantDto);
        restaurant.setId(id);
        Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);

        return Objects.nonNull(updateRestaurant)? ResponseEntity.ok(updateRestaurant) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity deleteClient(Long id) {
        return restaurantService.deleteRestaurant(id)?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.findById(id);

        return restaurant.isPresent() ? ResponseEntity.ok(restaurant.get()) : ResponseEntity.notFound().build();

    }
}
