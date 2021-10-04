package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.InventorySituationDto;
import br.edu.unoesc.pi2.restaurantes.mappers.InventoryMapper;
import br.edu.unoesc.pi2.restaurantes.models.Inventory;
import br.edu.unoesc.pi2.restaurantes.models.Item;
import br.edu.unoesc.pi2.restaurantes.repositorys.InventoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void newInventory(Item item, BigDecimal minQuantity) {
        inventoryRepository.save(new Inventory(BigDecimal.ZERO, minQuantity, item));
    }

    public InventorySituationDto checkInventory() {
        var inventoryMapper = InventoryMapper.INSTANCE;
        var inventorySituation = new InventorySituationDto();

        inventoryRepository.findAll()
                .parallelStream()
                .forEach(inventory -> {
                    if(inventory.getQuantity().compareTo(inventory.getMinQuantity()) < 0) {
                        inventorySituation
                                .addLackingInventory(inventoryMapper.inventoryToInventoryViewDto(inventory));
                    }

                    inventorySituation
                            .addInInventory(inventoryMapper.inventoryToInventoryViewDto(inventory));
                });

        return inventorySituation;
    }
}
