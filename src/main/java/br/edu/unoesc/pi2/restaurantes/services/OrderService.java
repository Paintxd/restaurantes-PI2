package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.OrderDto;
import br.edu.unoesc.pi2.restaurantes.dtos.OrderViewDto;
import br.edu.unoesc.pi2.restaurantes.mappers.OrderMapper;
import br.edu.unoesc.pi2.restaurantes.models.Order;
import br.edu.unoesc.pi2.restaurantes.models.OrderStatusEnum;
import br.edu.unoesc.pi2.restaurantes.models.User;
import br.edu.unoesc.pi2.restaurantes.repositorys.OrderRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuOrderService menuOrderService;

    public OrderService(OrderRepository orderRepository, MenuOrderService menuOrderService) {
        this.orderRepository = orderRepository;
        this.menuOrderService = menuOrderService;
    }

    public List<OrderDto> findAll(User user) {
        return orderRepository.findByClient(user)
                .parallelStream()
                .map(this::map)
                .toList();
    }

    public OrderDto findOrder(Integer id) throws NotFoundException {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order id: " + id + " not found"));

        return map(order);
    }

    public OrderDto newOrder(OrderViewDto orderDto) throws NotFoundException {
        var clientId = orderDto.getClientId();
        var employeeId = orderDto.getEmployeeId();
        var restaurantId = orderDto.getRestaurantId();
        Integer orderId = orderDto.getMenuOrders()
                .parallelStream()
                .map(menuOrder -> orderRepository.createOrder(clientId, employeeId, restaurantId, menuOrder.getMenuId(), menuOrder.getQuantity()))
                .toList()
                .get(0);

        return findOrder(orderId);
    }

    public OrderDto acceptOrder(Integer id) throws NotFoundException {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order id: " + id + " not found"));

        order.setStatus(OrderStatusEnum.ACCEPTED);

        return map(orderRepository.save(order));
    }

    public OrderDto finishOrder(Integer id) throws NotFoundException {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order id: " + id + " not found"));

        order.setStatus(OrderStatusEnum.FINISHED);
        order.setDeliveryDateTime(LocalDateTime.now());

        return map(orderRepository.save(order));
    }

    public OrderDto rejectOrder(Integer id) throws NotFoundException {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order id: " + id + " not found"));

        order.setStatus(OrderStatusEnum.REJECTED);
        order.setDeliveryDateTime(LocalDateTime.now());

        return map(orderRepository.save(order));
    }

    private OrderDto map(Order order) {
        var orderMapper = OrderMapper.INSTANCE;
        var menuItens = menuOrderService.findMenusOrder(order);

        return orderMapper.orderToOrderDto(order, menuItens);
    }
}
