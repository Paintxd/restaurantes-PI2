package br.edu.unoesc.pi2.restaurantes.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class CloseOrderPadDto {
    private Integer id;
    private LocalDateTime openDateTime;
    private LocalDateTime closeDateTime;
    private List<OrderDto> orders;
    private Double paymentAmount;

    public CloseOrderPadDto(Integer id, LocalDateTime openDateTime, LocalDateTime closeDateTime, List<OrderDto> orders, Double paymentAmount) {
        this.id = id;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.orders = orders;
        this.paymentAmount = paymentAmount;
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

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
