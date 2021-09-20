package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.RestaurantViewDto;
import br.edu.unoesc.pi2.restaurantes.models.Restaurant;
import br.edu.unoesc.pi2.restaurantes.services.RestaurantService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("info")
    public ResponseEntity<List<Restaurant>> restaurantsInfo() {
        return ResponseEntity.ok(restaurantService.findAllRestaurants());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Restaurant> restaurantInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(restaurantService.findRestaurant(id));
    }

    @PostMapping("new")
    public ResponseEntity<Restaurant> newRestaurant(@RequestBody @Valid RestaurantViewDto restaurantDto, UriComponentsBuilder uriBuilder) {
        var newRestaurant = restaurantService.newRestaurant(restaurantDto);
        var uri = uriBuilder.path("/restaurants/info/{id}").buildAndExpand(newRestaurant.getId()).toUri();

        return ResponseEntity.created(uri).body(newRestaurant);
    }

}
