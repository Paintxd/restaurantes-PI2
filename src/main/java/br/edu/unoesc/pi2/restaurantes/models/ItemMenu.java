package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "item_cardapio")
@Entity
public class ItemMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemcardapio_id")
    private Integer id;

    @Column(name = "qtde")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cardapio_id", referencedColumnName = "cardapio_id")
    private Menu menu;

    @ManyToMany
    @JoinTable(
            name = "r_estoque_itemcardapio",
            joinColumns = @JoinColumn(name = "itemcardapio_id"),
            inverseJoinColumns = @JoinColumn(name = "estoque_id"))
    private Set<Inventory> inventoryItems = new HashSet<>();

    public ItemMenu() {
    }

    public ItemMenu(Integer quantity, Menu menu, Set<Inventory> inventoryItems) {
        this.quantity = quantity;
        this.menu = menu;
        this.inventoryItems = inventoryItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemMenu itemMenu = (ItemMenu) o;
        return Objects.equals(id, itemMenu.id) && Objects.equals(quantity, itemMenu.quantity) && Objects.equals(menu, itemMenu.menu) && Objects.equals(inventoryItems, itemMenu.inventoryItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, menu, inventoryItems);
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Inventory> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Set<Inventory> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    @Override
    public String toString() {
        return "ItemMenu{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", menu=" + menu +
                ", inventoryItems=" + inventoryItems +
                '}';
    }
}
