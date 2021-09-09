package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "fornecedor")
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fornecedor_id")
    private Integer id;

    @Column(name = "nome_fantasia")
    private String name;

    @Column(name = "responsavel")
    private String inCharge;

    @Column(name = "dt_incl")
    private LocalDate insertionDate;

    private String cnpj;

    @Column(name = "inscricao_estadual")
    private String stateIdentifier;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "situacao")
    private SupplierStatusEnum status;

    public Supplier() {
    }

    public Supplier(String name, String inCharge, String cnpj, String stateIdentifier) {
        this.name = name;
        this.inCharge = inCharge;
        this.cnpj = cnpj;
        this.stateIdentifier = stateIdentifier;
        this.status = SupplierStatusEnum.ACTIVE;
        this.insertionDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) && Objects.equals(name, supplier.name) && Objects.equals(inCharge, supplier.inCharge) && Objects.equals(insertionDate, supplier.insertionDate) && Objects.equals(cnpj, supplier.cnpj) && Objects.equals(stateIdentifier, supplier.stateIdentifier) && status == supplier.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, inCharge, insertionDate, cnpj, stateIdentifier, status);
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

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inCharge='" + inCharge + '\'' +
                ", insertionDate=" + insertionDate +
                ", cnpj='" + cnpj + '\'' +
                ", stateIdentifier='" + stateIdentifier + '\'' +
                ", status=" + status +
                '}';
    }
}
