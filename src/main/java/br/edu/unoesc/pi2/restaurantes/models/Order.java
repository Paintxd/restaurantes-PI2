package br.edu.unoesc.pi2.restaurantes.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "pedido")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer id;

    @Column(name = "dt_inic")
    private LocalDateTime orderDateTime;

    @Column(name = "dt_fim")
    private LocalDateTime deliveryDateTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "aprovado")
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "comanda_id", referencedColumnName = "comanda_id")
    private OrderPad orderPad;

    @ManyToOne
    @JoinColumn(name = "usuario_id_cliente", referencedColumnName = "usuario_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "usuario_id_funcionario", referencedColumnName = "usuario_id")
    private User attendant;

    public Order() {
    }

    public Order(LocalDateTime orderDateTime, LocalDateTime deliveryDateTime, OrderPad orderPad, User client, User attendant) {
        this.orderDateTime = orderDateTime;
        this.deliveryDateTime = deliveryDateTime;
        this.orderPad = orderPad;
        this.client = client;
        this.attendant = attendant;
        this.status = OrderStatusEnum.OPENED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderDateTime, order.orderDateTime) && Objects.equals(deliveryDateTime, order.deliveryDateTime) && status == order.status && Objects.equals(orderPad, order.orderPad) && Objects.equals(client, order.client) && Objects.equals(attendant, order.attendant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDateTime, deliveryDateTime, status, orderPad, client, attendant);
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public OrderPad getOrderPad() {
        return orderPad;
    }

    public void setOrderPad(OrderPad orderPad) {
        this.orderPad = orderPad;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getAttendant() {
        return attendant;
    }

    public void setAttendant(User attendant) {
        this.attendant = attendant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", deliveryDateTime=" + deliveryDateTime +
                ", status=" + status +
                ", orderPad=" + orderPad +
                ", client=" + client +
                ", attendant=" + attendant +
                '}';
    }
}
