package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.SupplierDto;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import br.edu.unoesc.pi2.restaurantes.services.SupplierService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SupplierService supplierService;

    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("info")
    public ResponseEntity<Set<SupplierDto>> suppliersInfo() {
        return ResponseEntity.ok(supplierService.findAllSuppliers());
    }

    @GetMapping("info/{id}")
    public ResponseEntity<SupplierDto> supplierInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(supplierService.findSupplier(id));
    }

    @PostMapping("new")
    public ResponseEntity<Supplier> newSupplier(@RequestBody @Valid SupplierDto supplierDto, UriComponentsBuilder uriBuilder) {
        var newSupplier = supplierService.newSupplier(supplierDto);
        var uri = uriBuilder.path("/user/info/{id}").buildAndExpand(newSupplier.getId()).toUri();

        return ResponseEntity.created(uri).body(newSupplier);
    }

}
