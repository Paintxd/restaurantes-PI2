package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderViewDto {

    @NotNull(message = "Informe o cliente que fez o pedido")
    private int clientId;

    @NotNull(message = "Informe o funcionario que atendeu esse pedido")
    private int employeeId;

    @NotNull(message = "Informe o restaurante de onde foi feito o pedido")
    private int restaurantId;

    @NotNull(message = "Informe os itens do cardapio que foram pedido")
    @Size(min = 1, message = "Informe ao menos um item do cardapio para abrir um pedido")
    private List<MenuOrderViewDto> menuOrders;

    public OrderViewDto(int clientId, int employeeId, int restaurantId, List<MenuOrderViewDto> menuOrders) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.restaurantId = restaurantId;
        this.menuOrders = menuOrders;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<MenuOrderViewDto> getMenuOrders() {
        return menuOrders;
    }

    public void setMenuOrders(List<MenuOrderViewDto> menuOrders) {
        this.menuOrders = menuOrders;
    }
}
