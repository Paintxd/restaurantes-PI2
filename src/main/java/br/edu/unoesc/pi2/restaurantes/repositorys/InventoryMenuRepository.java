package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.InventoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryMenuRepository extends JpaRepository<InventoryMenu, Integer> {
}