package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "cardapio")
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardapio_id")
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "vlr_preparo")
    private Double price;

    @Column(name = "tempo_preparo")
    private Integer preparationTime;

    @ManyToOne
    @JoinColumn(name = "unidade_id", referencedColumnName = "unidade_id")
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(String name, Double price, Integer preparationTime, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(name, menu.name) && Objects.equals(price, menu.price) && Objects.equals(preparationTime, menu.preparationTime) && Objects.equals(restaurant, menu.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, preparationTime, restaurant);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                ", restaurant=" + restaurant +
                '}';
    }
}
