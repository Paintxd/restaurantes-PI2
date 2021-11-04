package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.OrderStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private OrderStatusEnum orderStatus;
    private Integer orderPadId;
    private String client;
    private String employee;
    private List<MenuOrderDto> menuItens;

    public OrderDto(Integer id, LocalDateTime startDate, LocalDateTime endDate, OrderStatusEnum orderStatus, Integer orderPadId, String client, String employee, List<MenuOrderDto> menuItens) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orderStatus = orderStatus;
        this.orderPadId = orderPadId;
        this.client = client;
        this.employee = employee;
        this.menuItens = menuItens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderPadId() {
        return orderPadId;
    }

    public void setOrderPadId(Integer orderPadId) {
        this.orderPadId = orderPadId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<MenuOrderDto> getMenuItens() {
        return menuItens;
    }

    public void setMenuItens(List<MenuOrderDto> menuItens) {
        this.menuItens = menuItens;
    }
}
