package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.Menu;
import br.edu.unoesc.pi2.restaurantes.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByRestaurant(Restaurant restaurant);
}