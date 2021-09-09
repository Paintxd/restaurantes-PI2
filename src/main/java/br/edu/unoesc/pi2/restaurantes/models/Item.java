package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "item")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "cd")
    private Integer code;

    @Column(name = "descricao")
    private String description;

    @Column(name = "unidade_medida")
    private String measurementUnit;

    @Column(name = "vlr")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "fornecedor_id")
    private Supplier supplier;

    public Item() {
    }

    public Item(Integer code, String description, String measurementUnit, Double value, Supplier supplier) {
        this.code = code;
        this.description = description;
        this.measurementUnit = measurementUnit;
        this.value = value;
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && code.equals(item.code) && description.equals(item.description) && measurementUnit.equals(item.measurementUnit) && value.equals(item.value) && supplier.equals(item.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description, measurementUnit, value, supplier);
    }

    public Integer getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
