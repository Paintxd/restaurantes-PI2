package br.edu.unoesc.pi2.restaurantes.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "tipo_pessoa")
@Entity
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "tppessoa_id")
    private int id;

    @Column(name = "descricao")
    private String description;

    public UserRole() {
    }

    public UserRole(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return this.description;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}