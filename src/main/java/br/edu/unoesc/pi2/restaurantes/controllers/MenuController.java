package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuDto;
import br.edu.unoesc.pi2.restaurantes.dtos.MenuViewDto;
import br.edu.unoesc.pi2.restaurantes.services.MenuService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/info/restaurant/{id}")
    public ResponseEntity<List<MenuDto>> restaurantMenus(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(menuService.getRestaurantMenus(id));
    }

    @PostMapping("new")
    public ResponseEntity<MenuDto> newMenuItem(@RequestBody @Valid MenuViewDto menuDto, UriComponentsBuilder uriBuilder) throws NotFoundException {
        var newMenu = menuService.newMenuItem(menuDto);
        var uri = uriBuilder.path("/menus/info/{id}").buildAndExpand(newMenu.getId()).toUri();

        return ResponseEntity.created(uri).body(newMenu);
    }
}
