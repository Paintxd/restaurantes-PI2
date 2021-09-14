package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.SupplierViewDto;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import br.edu.unoesc.pi2.restaurantes.services.SupplierService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("info")
    public ResponseEntity<List<Supplier>> suppliersInfo() {
        return ResponseEntity.ok(supplierService.findAllSuppliers());
    }

    @GetMapping("info/{id}")
    public ResponseEntity<Supplier> supplierInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(supplierService.findSupplier(id));
    }

    @PostMapping("new")
    public ResponseEntity<Supplier> newSupplier(@RequestBody @Valid SupplierViewDto supplierDto, UriComponentsBuilder uriBuilder) {
        var newSupplier = supplierService.newSupplier(supplierDto);
        var uri = uriBuilder.path("/suppliers/info/{id}").buildAndExpand(newSupplier.getId()).toUri();

        return ResponseEntity.created(uri).body(newSupplier);
    }

    @PatchMapping("disable/{id}")
    public ResponseEntity<Supplier> disableSupplier(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(supplierService.disableSupplier(id));
    }

}
