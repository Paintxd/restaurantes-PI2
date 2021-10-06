package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.InventoryMenuDto;
import br.edu.unoesc.pi2.restaurantes.models.InventoryMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMenuMapper {
    InventoryMenuMapper INSTANCE = Mappers.getMapper(InventoryMenuMapper.class);

    @Mapping(source = "inventory.item.description", target = "ingredient")
    @Mapping(expression = "java(inventoryMenu.getQuantity() + \" \" + inventoryMenu.getInventory().getItem().getMeasurementUnit())", target = "quantity")
    InventoryMenuDto inventoryMenuToInventoryMenuDto(InventoryMenu inventoryMenu);
}
