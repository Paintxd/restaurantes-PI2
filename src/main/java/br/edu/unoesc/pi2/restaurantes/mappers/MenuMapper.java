package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.InventoryMenuDto;
import br.edu.unoesc.pi2.restaurantes.dtos.MenuDto;
import br.edu.unoesc.pi2.restaurantes.models.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    @Mapping(source = "menu.id", target = "id")
    @Mapping(source = "menu.name", target = "name")
    @Mapping(source = "menu.restaurant.name", target = "restaurant")
    @Mapping(source = "menu.price", target = "price")
    @Mapping(source = "menu.preparationTime", target = "preparationTime")
    @Mapping(source = "inventoryMenuDto", target = "ingredients")
    MenuDto inventoryMenuToMenuDto(Menu menu, List<InventoryMenuDto> inventoryMenuDto);
}
