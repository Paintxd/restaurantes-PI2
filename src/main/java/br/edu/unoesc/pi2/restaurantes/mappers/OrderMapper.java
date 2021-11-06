package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuOrderDto;
import br.edu.unoesc.pi2.restaurantes.dtos.OrderDto;
import br.edu.unoesc.pi2.restaurantes.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.orderDateTime", target = "startDate")
    @Mapping(source = "order.deliveryDateTime", target = "endDate")
    @Mapping(source = "order.status", target = "orderStatus")
    @Mapping(source = "order.orderPad.id", target = "orderPadId")
    @Mapping(source = "order.client.name", target = "client")
    @Mapping(source = "order.attendant.name", target = "employee")
    @Mapping(source = "menuItens", target = "menuItens")
    OrderDto orderToOrderDto(Order order, List<MenuOrderDto> menuItens);
}
