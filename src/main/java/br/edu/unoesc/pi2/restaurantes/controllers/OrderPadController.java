package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.CloseOrderPadDto;
import br.edu.unoesc.pi2.restaurantes.dtos.OpenOrderPadDto;
import br.edu.unoesc.pi2.restaurantes.models.User;
import br.edu.unoesc.pi2.restaurantes.services.OrderPadService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderPad")
public class OrderPadController {

    private final OrderPadService orderPadService;

    public OrderPadController(OrderPadService orderPadService) {
        this.orderPadService = orderPadService;
    }

    @GetMapping("/inProgress")
    public ResponseEntity<List<OpenOrderPadDto>> orderPadsInProcess() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(orderPadService.orderPadsInProcess(user));
    }

    @PostMapping("/close")
    public ResponseEntity<CloseOrderPadDto> closeOrderPad() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(orderPadService.closeOrderPad(user));
    }
}
