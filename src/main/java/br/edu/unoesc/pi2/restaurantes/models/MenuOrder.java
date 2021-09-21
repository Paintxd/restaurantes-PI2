package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "cardapio_pedido")
@Entity
public class MenuOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardapio_pedido_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cardapio_id", referencedColumnName = "cardapio_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedido_id")
    private Order order;

    @Column(name = "qtde")
    private Integer quantity;

    public MenuOrder() {
    }

    public MenuOrder(Menu menu, Order order, Integer quantity) {
        this.menu = menu;
        this.order = order;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuOrder menuOrder = (MenuOrder) o;
        return Objects.equals(id, menuOrder.id) && Objects.equals(menu, menuOrder.menu) && Objects.equals(order, menuOrder.order) && Objects.equals(quantity, menuOrder.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menu, order, quantity);
    }

    public Integer getId() {
        return id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MenuOrder{" +
                "id=" + id +
                ", menu=" + menu +
                ", order=" + order +
                ", quantity=" + quantity +
                '}';
    }
}
