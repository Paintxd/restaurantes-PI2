package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.OrderDto;
import br.edu.unoesc.pi2.restaurantes.dtos.OrderViewDto;
import br.edu.unoesc.pi2.restaurantes.models.User;
import br.edu.unoesc.pi2.restaurantes.services.OrderService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/info")
    public ResponseEntity<List<OrderDto>> allOrdersInfo() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(orderService.findAll(user));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<OrderDto> orderInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok().body(orderService.findOrder(id));
    }

    @PostMapping("/new")
    public ResponseEntity<OrderDto> newOrder(@RequestBody @Valid OrderViewDto orderDto, UriComponentsBuilder uriBuilder) throws NotFoundException {
        var newOrder = this.orderService.newOrder(orderDto);
        var uri = uriBuilder.path("/orders/info/{id}").buildAndExpand(newOrder.getId()).toUri();

        return ResponseEntity.created(uri).body(newOrder);
    }

    @PatchMapping("/accept/{id}")
    public ResponseEntity<OrderDto> acceptOrder(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok().body(orderService.acceptOrder(id));
    }

    @PatchMapping("/finish/{id}")
    public ResponseEntity<OrderDto> finishOrder(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok().body(orderService.finishOrder(id));
    }

    @PatchMapping("/reject/{id}")
    public ResponseEntity<OrderDto> rejectOrder(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok().body(orderService.finishOrder(id));
    }

}
