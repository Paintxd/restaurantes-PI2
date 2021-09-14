package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.ItemDto;
import br.edu.unoesc.pi2.restaurantes.models.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "measurementUnit", target = "measurementUnit")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "supplier.name", target = "supplier")
    ItemDto itemToItemDto(Item item);


}
