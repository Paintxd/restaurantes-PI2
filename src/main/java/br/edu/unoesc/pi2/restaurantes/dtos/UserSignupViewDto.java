package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserSignupViewDto {

    @NotBlank(message = "Informe um nome")
    private String name;

    @NotBlank(message = "Informe um cpf")
    @Length(min = 11, max = 11, message = "Informe um cpf valido")
    private String cpf;

    @NotBlank(message = "Informe um telefone")
    @Length(min = 11, max = 11, message = "Informe um telefone valido")
    private String phoneNumber;

    @NotBlank(message = "Informe um email")
    @Email
    private String email;

    @NotBlank(message = "Informe uma senha")
    @Length(min = 6, max = 15, message = "Informe uma senha valida")
    private String password;

    @NotBlank(message = "Informe um tipo de usuario")
    private String userRole;

    @NotBlank(message = "Informe um endereço")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return new User(name, cpf, address, phoneNumber, email, password);
    }

}
