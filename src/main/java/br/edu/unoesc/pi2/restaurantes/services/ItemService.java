package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.ItemDto;
import br.edu.unoesc.pi2.restaurantes.dtos.ItemViewDto;
import br.edu.unoesc.pi2.restaurantes.mappers.ItemMapper;
import br.edu.unoesc.pi2.restaurantes.repositorys.ItemRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final SupplierService supplierService;
    private final InventoryService inventoryService;

    public ItemService(ItemRepository itemRepository, SupplierService supplierService, InventoryService inventoryService) {
        this.itemRepository = itemRepository;
        this.supplierService = supplierService;
        this.inventoryService = inventoryService;
    }

    public List<ItemDto> findAllItems() {
        var itemMapper = ItemMapper.INSTANCE;
        return itemRepository.findAll()
                .parallelStream()
                .map(itemMapper::itemToItemDto)
                .toList();
    }

    public ItemDto findItem(Integer id) throws NotFoundException {
        var item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item id: " + id + " not found"));
        var itemMapper = ItemMapper.INSTANCE;

        return itemMapper.itemToItemDto(item);
    }

    public ItemDto newItem(ItemViewDto itemDto) throws NotFoundException {
        var supplier = supplierService.findSupplier(itemDto.getSupplierId());
        var item = itemDto.getItem(supplier);
        var newItem = itemRepository.save(item);
        inventoryService.newInventory(newItem, itemDto.getMinQuantity());

        var itemMapper = ItemMapper.INSTANCE;

        return itemMapper.itemToItemDto(newItem);
    }

}
