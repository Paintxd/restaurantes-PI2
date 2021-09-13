package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Item;
import br.edu.unoesc.pi2.restaurantes.models.Supplier;

import javax.validation.constraints.NotBlank;

public class ItemViewDto {

    @NotBlank(message = "Informe uma descricao")
    private String description;

    @NotBlank(message = "Informe uma unidade de medida")
    private String measurementUnit;

    @NotBlank(message = "Informe um valor")
    private Double value;

    @NotBlank(message = "Informe um fornecedor")
    private Integer supplierId;

    public ItemViewDto(String description, String measurementUnit, Double value, Integer supplierId) {
        this.description = description;
        this.measurementUnit = measurementUnit;
        this.value = value;
        this.supplierId = supplierId;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Item getItem(Supplier supplier) {
        return new Item(description, measurementUnit, value, supplier);
    }
}
