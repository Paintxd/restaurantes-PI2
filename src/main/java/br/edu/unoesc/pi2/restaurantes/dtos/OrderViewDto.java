package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderViewDto {

    @NotNull(message = "Informe o cliente que fez o pedido")
    private Integer clientId;

    @NotNull(message = "Informe o funcionario que atendeu esse pedido")
    private Integer employeeId;

    @NotNull(message = "Informe o restaurante de onde foi feito o pedido")
    private Integer restaurantId;

    @NotNull(message = "Informe os itens do cardapio que foram pedido")
    @Size(min = 1, message = "Informe ao menos um item do cardapio para abrir um pedido")
    private List<MenuOrderViewDto> menuOrders;

    public OrderViewDto(Integer clientId, Integer employeeId, Integer restaurantId, List<MenuOrderViewDto> menuOrders) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.restaurantId = restaurantId;
        this.menuOrders = menuOrders;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<MenuOrderViewDto> getMenuOrders() {
        return menuOrders;
    }

    public void setMenuOrders(List<MenuOrderViewDto> menuOrders) {
        this.menuOrders = menuOrders;
    }
}
