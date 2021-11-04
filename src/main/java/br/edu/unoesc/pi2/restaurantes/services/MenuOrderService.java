package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.MenuOrderDto;
import br.edu.unoesc.pi2.restaurantes.mappers.MenuOrderMapper;
import br.edu.unoesc.pi2.restaurantes.models.Order;
import br.edu.unoesc.pi2.restaurantes.repositorys.MenuOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuOrderService {
    private final MenuOrderRepository menuOrderRepository;

    public MenuOrderService(MenuOrderRepository menuOrderRepository) {
        this.menuOrderRepository = menuOrderRepository;
    }

    public List<MenuOrderDto> findMenusOrder(Order order) {
        var menuOrderMapper = MenuOrderMapper.INSTANCE;

        return menuOrderRepository.findByOrder(order)
                .parallelStream()
                .map(menuOrderMapper::menuOrderToMenuOrderDto)
                .toList();
    }
}
