package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "estoque")
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Integer id;

    @Column(name = "qtde")
    private Double quantity;

    @Column(name = "qtde_minima")
    private Double minQuantity;

    @Column(name = "dt_atualizacao")
    private LocalDate updateDate;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    public Inventory() {
    }

    public Inventory(Double quantity, Double minQuantity, Item item) {
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.item = item;
        this.updateDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return id.equals(inventory.id) && quantity.equals(inventory.quantity) && minQuantity.equals(inventory.minQuantity) && updateDate.equals(inventory.updateDate) && item.equals(inventory.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, minQuantity, updateDate, item);
    }

    public Integer getId() {
        return id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
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
                ", updateDate=" + updateDate +
                ", item=" + item +
                '}';
    }
}
