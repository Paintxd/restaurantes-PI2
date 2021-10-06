package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.models.InventoryMenu;
import br.edu.unoesc.pi2.restaurantes.models.Menu;
import br.edu.unoesc.pi2.restaurantes.repositorys.InventoryMenuRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InventoryMenuService {

    private final InventoryMenuRepository inventoryMenuRepository;
    private final InventoryService inventoryService;

    public InventoryMenuService(InventoryMenuRepository inventoryMenuRepository, InventoryService inventoryService) {
        this.inventoryMenuRepository = inventoryMenuRepository;
        this.inventoryService = inventoryService;
    }

    public InventoryMenu newInventoryMenu(Integer inventoryId, Menu menu, BigDecimal quantity) {
        try {
            var inventory = inventoryService.findInventoryForMenu(inventoryId);

            return inventoryMenuRepository.save(new InventoryMenu(inventory, menu, quantity));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
