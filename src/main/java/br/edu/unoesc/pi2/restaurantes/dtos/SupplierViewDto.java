package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Supplier;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class SupplierViewDto {

    @NotBlank(message = "Informe um nome")
    private String name;

    @NotBlank(message = "Informe um responsavel")
    private String inCharge;

    @NotBlank(message = "Informe um cnpj")
    @Length(min = 14, message = "Informe um cnpj valido")
    private String cnpj;

    @NotBlank(message = "Informe um identificador estadual")
    @Length(min = 9, max = 14, message = "Identificacao estadual deve possuir no minimo 9 e no maximo 14 caracteres")
    private String stateIdentifier;

    public SupplierViewDto(String name, String inCharge, String cnpj, String stateIdentifier) {
        this.name = name;
        this.inCharge = inCharge;
        this.cnpj = cnpj;
        this.stateIdentifier = stateIdentifier;
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

    public Supplier getSupplier() {
        return new Supplier(name, inCharge, cnpj, stateIdentifier);
    }
}
