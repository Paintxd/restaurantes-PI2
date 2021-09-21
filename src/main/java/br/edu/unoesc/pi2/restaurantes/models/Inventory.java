package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "estoque")
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Integer id;

    @Column(name = "qtde")
    private BigDecimal quantity;

    @Column(name = "qtde_minima")
    private BigDecimal minQuantity;

    @Column(name = "dt_atualizacao")
    private LocalDateTime updateDateTime;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    public Inventory() {
    }

    public Inventory(BigDecimal quantity, BigDecimal minQuantity, Item item) {
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.item = item;
        this.updateDateTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return id.equals(inventory.id) && quantity.equals(inventory.quantity) && minQuantity.equals(inventory.minQuantity) && updateDateTime.equals(inventory.updateDateTime) && item.equals(inventory.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, minQuantity, updateDateTime, item);
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", minQuantity=" + minQuantity +
                ", updateDateTime=" + updateDateTime +
                ", item=" + item +
                '}';
    }
}
