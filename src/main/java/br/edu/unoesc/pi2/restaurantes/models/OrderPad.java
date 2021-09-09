package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "comanda")
@Entity
public class OrderPad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comanda_id")
    private Integer id;

    @Column(name = "dt_inic")
    private LocalDateTime openDateTime;

    @Column(name = "dt_encerramento")
    private LocalDateTime closeDateTime;

    @Column(name = "vlr_total")
    private Double paymentAmount;


    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private User client;

    public OrderPad() {
    }

    public OrderPad(LocalDateTime openDateTime, LocalDateTime closeDateTime, Double paymentAmount, User client) {
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.paymentAmount = paymentAmount;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPad orderPad = (OrderPad) o;
        return Objects.equals(id, orderPad.id) && Objects.equals(openDateTime, orderPad.openDateTime) && Objects.equals(closeDateTime, orderPad.closeDateTime) && Objects.equals(paymentAmount, orderPad.paymentAmount) && Objects.equals(client, orderPad.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openDateTime, closeDateTime, paymentAmount, client);
    }

    public Integer getId() {
        return id;
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

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "OrderPad{" +
                "id=" + id +
                ", openDateTime=" + openDateTime +
                ", closeDateTime=" + closeDateTime +
                ", paymentAmount=" + paymentAmount +
                ", client=" + client +
                '}';
    }
}