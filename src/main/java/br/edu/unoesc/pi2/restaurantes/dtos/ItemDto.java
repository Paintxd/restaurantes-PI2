package br.edu.unoesc.pi2.restaurantes.dtos;

public class ItemDto {
    private Integer id;
    private Integer code;
    private String description;
    private String measurementUnit;
    private Double value;
    private String supplier;

    public ItemDto(Integer id, Integer code, String description, String measurementUnit, Double value, String supplier) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.measurementUnit = measurementUnit;
        this.value = value;
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
