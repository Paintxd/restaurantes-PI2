package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}