package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}