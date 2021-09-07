package br.edu.unoesc.pi2.restaurantes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @GetMapping
    private ResponseEntity<String> getPedidos() {
        return ResponseEntity.ok().body("ta ai");
    }
}
