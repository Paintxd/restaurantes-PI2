package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.InventoryDto;
import br.edu.unoesc.pi2.restaurantes.dtos.InventorySituationDto;
import br.edu.unoesc.pi2.restaurantes.dtos.InventoryViewDto;
import br.edu.unoesc.pi2.restaurantes.services.InventoryService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("info/{id}")
    public ResponseEntity<InventoryDto> itemInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(inventoryService.findInventory(id));
    }

    @GetMapping("check")
    public ResponseEntity<InventorySituationDto> inventoryCheck() {
        return ResponseEntity.ok(inventoryService.checkInventory());
    }

    @PostMapping("fill/{id}")
    public ResponseEntity<InventoryDto> fillInventory(@PathVariable Integer id, @RequestBody @Valid InventoryViewDto inventoryDto) throws NotFoundException {
        return ResponseEntity.ok(inventoryService.fillInventory(id, inventoryDto));
    }

}
