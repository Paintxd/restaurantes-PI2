package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.InventoryDto;
import br.edu.unoesc.pi2.restaurantes.models.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "minQuantity", target = "minQuantity")
    @Mapping(source = "updateDateTime", target = "updateDateTime")
    @Mapping(source = "item.description", target = "itemName")
    @Mapping(source = "item.supplier.name", target = "supplierName")
    InventoryDto inventoryToInventoryDto(Inventory inventory);
}
