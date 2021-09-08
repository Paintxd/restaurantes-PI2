package br.edu.unoesc.pi2.restaurantes.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "supplier")
    private Set<Item> items = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String name, String inCharge, String cnpj, String stateIdentifier, Set<Item> items) {
        this.name = name;
        this.inCharge = inCharge;
        this.cnpj = cnpj;
        this.stateIdentifier = stateIdentifier;
        this.items = items;
        this.insertionDate = LocalDate.now();
        this.status = SupplierStatusEnum.ACTIVE;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
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
                ", items=" + items +
                '}';
    }
}
