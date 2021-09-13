package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.SupplierStatusEnum;

import java.time.LocalDate;

public class SupplierDto {

    private String name;

    private String inCharge;

    private LocalDate insertionDate;

    private String cnpj;

    private String stateIdentifier;

    private SupplierStatusEnum status;

    public SupplierDto(String name, String inCharge, LocalDate insertionDate, String cnpj, String stateIdentifier, SupplierStatusEnum status) {
        this.name = name;
        this.inCharge = inCharge;
        this.insertionDate = insertionDate;
        this.cnpj = cnpj;
        this.stateIdentifier = stateIdentifier;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInCharge() {
        return inCharge;
    }

    public void setInCharge(String inCharge) {
        this.inCharge = inCharge;
    }

    public LocalDate getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(LocalDate insertionDate) {
        this.insertionDate = insertionDate;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateIdentifier() {
        return stateIdentifier;
    }

    public void setStateIdentifier(String stateIdentifier) {
        this.stateIdentifier = stateIdentifier;
    }

    public SupplierStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SupplierStatusEnum status) {
        this.status = status;
    }
}
