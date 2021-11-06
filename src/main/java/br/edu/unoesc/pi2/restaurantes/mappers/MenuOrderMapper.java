package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuOrderDto;
import br.edu.unoesc.pi2.restaurantes.models.MenuOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuOrderMapper {
    MenuOrderMapper INSTANCE = Mappers.getMapper(MenuOrderMapper.class);

    @Mapping(source = "menu.name", target = "menu")
    @Mapping(source = "quantity", target = "quantity")
    MenuOrderDto menuOrderToMenuOrderDto(MenuOrder menuOrder);
}
