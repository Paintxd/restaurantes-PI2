package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.RestaurantViewDto;
import br.edu.unoesc.pi2.restaurantes.models.Restaurant;
import br.edu.unoesc.pi2.restaurantes.repositorys.RestaurantRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurant(Integer id) throws NotFoundException {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant id: " + id + " not found"));
    }

    public Restaurant newRestaurant(RestaurantViewDto restaurantDto) {
        var restaurant = restaurantDto.getRestaurant();

        return restaurantRepository.save(restaurant);
    }

}
