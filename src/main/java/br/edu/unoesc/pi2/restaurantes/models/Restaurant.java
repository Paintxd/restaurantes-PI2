package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;

@Table(name = "unidade")
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unidade_id")
    private Integer id;

    @Column(name = "segmento")
    private String type;

    public Restaurant() {
    }

    public Restaurant(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
