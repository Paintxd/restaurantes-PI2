package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.ItemDto;
import br.edu.unoesc.pi2.restaurantes.dtos.ItemViewDto;
import br.edu.unoesc.pi2.restaurantes.services.ItemService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("info")
    public ResponseEntity<List<ItemDto>> itemsInfo() {
        return ResponseEntity.ok(itemService.findAllItems());
    }

    @GetMapping("info/{id}")
    public ResponseEntity<ItemDto> itemInfo(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(itemService.findItem(id));
    }

    @PostMapping("new")
    public ResponseEntity<ItemDto> newItem(@RequestBody @Valid ItemViewDto itemDto, UriComponentsBuilder uriBuilder) throws NotFoundException {
        var newItem = itemService.newItem(itemDto);
        var uri = uriBuilder.path("/items/info/{id}").buildAndExpand(newItem.getId()).toUri();

        return ResponseEntity.created(uri).body(newItem);
    }

}
