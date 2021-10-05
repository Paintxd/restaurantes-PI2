package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.InventoryDto;
import br.edu.unoesc.pi2.restaurantes.dtos.InventorySituationDto;
import br.edu.unoesc.pi2.restaurantes.dtos.InventoryViewDto;
import br.edu.unoesc.pi2.restaurantes.mappers.InventoryMapper;
import br.edu.unoesc.pi2.restaurantes.models.Inventory;
import br.edu.unoesc.pi2.restaurantes.models.Item;
import br.edu.unoesc.pi2.restaurantes.repositorys.InventoryRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryDto findInventory(Integer id) throws NotFoundException {
        var inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventory id: " + id + " not found"));
        var inventoryMapper = InventoryMapper.INSTANCE;

        return inventoryMapper.inventoryToInventoryDto(inventory);
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
                                .addLackingInventory(inventoryMapper.inventoryToInventoryDto(inventory));
                        return;
                    }

                    inventorySituation
                            .addInInventory(inventoryMapper.inventoryToInventoryDto(inventory));
                });

        return inventorySituation;
    }

    public InventoryDto fillInventory(Integer id, InventoryViewDto inventoryDto) throws NotFoundException {
        var inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventory id: " + id + " not found"));
        inventory.fillInventory(inventoryDto.getQuantity());

        var inventoryMapper = InventoryMapper.INSTANCE;

        return inventoryMapper.inventoryToInventoryDto(inventoryRepository.save(inventory));
    }

    public Inventory findInventoryForMenu(Integer id) throws NotFoundException {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventory id: " + id + " not found"));
    }

}
