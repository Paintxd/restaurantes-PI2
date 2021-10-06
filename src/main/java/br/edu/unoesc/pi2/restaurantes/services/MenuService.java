package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuDto;
import br.edu.unoesc.pi2.restaurantes.dtos.MenuViewDto;
import br.edu.unoesc.pi2.restaurantes.mappers.InventoryMenuMapper;
import br.edu.unoesc.pi2.restaurantes.mappers.MenuMapper;
import br.edu.unoesc.pi2.restaurantes.repositorys.MenuRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final InventoryMenuService inventoryMenuService;
    private final RestaurantService restaurantService;

    public MenuService(MenuRepository menuRepository, InventoryMenuService inventoryMenuService, RestaurantService restaurantService) {
        this.menuRepository = menuRepository;
        this.inventoryMenuService = inventoryMenuService;
        this.restaurantService = restaurantService;
    }

    public MenuDto newMenuItem(MenuViewDto menuDto) throws NotFoundException {
        var restaurant = restaurantService.findRestaurant(menuDto.getRestaurantId());
        var menu = menuRepository.save(menuDto.getMenu(restaurant));

        var inventoryMenuMapper = InventoryMenuMapper.INSTANCE;
        var inventoryMenuDto =
                menuDto.getInventoryItems()
                .parallelStream()
                .map(inventoryMenuItem -> {
                    var inventoryMenu = inventoryMenuService
                            .newInventoryMenu(inventoryMenuItem.getInventoryId(), menu, inventoryMenuItem.getQuantity());

                    return inventoryMenuMapper.inventoryMenuToInventoryMenuDto(inventoryMenu);
                }).toList();

        var menuMapper = MenuMapper.INSTANCE;
        return menuMapper.inventoryMenuToMenuDto(menu, inventoryMenuDto);
    }

}
