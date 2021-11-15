package br.edu.unoesc.pi2.restaurantes.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class OpenOrderPadDto {
    private Integer id;
    private LocalDateTime openDateTime;
    private List<OrderDto> orders;

    public OpenOrderPadDto(Integer id, LocalDateTime openDateTime, List<OrderDto> orders) {
        this.id = id;
        this.openDateTime = openDateTime;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(LocalDateTime openDateTime) {
        this.openDateTime = openDateTime;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
