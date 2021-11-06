package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.MenuOrder;
import br.edu.unoesc.pi2.restaurantes.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuOrderRepository extends JpaRepository<MenuOrder, Integer> {
    List<MenuOrder> findByOrder(Order order);
}