package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuDto;
import br.edu.unoesc.pi2.restaurantes.dtos.MenuViewDto;
import br.edu.unoesc.pi2.restaurantes.services.MenuService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("new")
    public ResponseEntity<MenuDto> newMenuItem(@RequestBody @Valid MenuViewDto menuDto, UriComponentsBuilder uriBuilder) throws NotFoundException {
        var newMenu = menuService.newMenuItem(menuDto);
        var uri = uriBuilder.path("/menus/info/{id}").buildAndExpand(newMenu.getId()).toUri();

        return ResponseEntity.created(uri).body(newMenu);
    }
}
