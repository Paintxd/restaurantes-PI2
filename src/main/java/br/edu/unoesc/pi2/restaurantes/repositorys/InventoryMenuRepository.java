package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.InventoryMenu;
import br.edu.unoesc.pi2.restaurantes.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryMenuRepository extends JpaRepository<InventoryMenu, Integer> {
    List<InventoryMenu> findByMenu(Menu menu);
}