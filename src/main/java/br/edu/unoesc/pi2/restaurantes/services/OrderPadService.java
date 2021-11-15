package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.OpenOrderPadDto;
import br.edu.unoesc.pi2.restaurantes.models.User;
import br.edu.unoesc.pi2.restaurantes.repositorys.OrderPadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPadService {

    private final OrderPadRepository orderPadRepository;
    private final OrderService orderService;

    public OrderPadService(OrderPadRepository orderPadRepository, OrderService orderService) {
        this.orderPadRepository = orderPadRepository;
        this.orderService = orderService;
    }

    public List<OpenOrderPadDto> orderPadsInProcess(User user) {
        return orderPadRepository.findByClientAndCloseDateTimeIsNull(user)
                .parallelStream()
                .map(orderPad -> {
                    var orders = orderService.findOrderPadOrders(orderPad);

                    return new OpenOrderPadDto(orderPad.getId(), orderPad.getOpenDateTime(), orders);
                })
                .toList();
    }

    public void closeOrderPad(User user) {
        orderPadRepository.closeOrderPad(user.getId());
    }
}
