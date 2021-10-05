package br.edu.unoesc.pi2.restaurantes.dtos;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginViewDto {

    @NotBlank(message = "Informe um email")
    @Email
    private String email;

    @NotBlank(message = "Informe uma senha")
    @Length(min = 5, message = "Senha deve possuir no minimo 5 caracteres")
    private String password;

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

    public UsernamePasswordAuthenticationToken getUPAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
