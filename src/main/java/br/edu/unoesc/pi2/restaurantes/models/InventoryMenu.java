package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "estoque_cardapio")
@Entity
public class InventoryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_cardapio_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estoque_id", referencedColumnName = "estoque_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "cardapio_id", referencedColumnName = "cardapio_id")
    private Menu menu;

    @Column(name = "qtde")
    private BigDecimal quantity;

    public InventoryMenu() {
    }

    public InventoryMenu(Inventory inventory, Menu menu, BigDecimal quantity) {
        this.inventory = inventory;
        this.menu = menu;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryMenu that = (InventoryMenu) o;
        return Objects.equals(id, that.id) && Objects.equals(inventory, that.inventory) && Objects.equals(menu, that.menu) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory, menu, quantity);
    }

    public Integer getId() {
        return id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryMenu{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", menu=" + menu +
                ", quantity=" + quantity +
                '}';
    }
}
