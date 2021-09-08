package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.LoginDto;
import br.edu.unoesc.pi2.restaurantes.dtos.TokenDto;
import br.edu.unoesc.pi2.restaurantes.services.LoginService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    private final LoginService loginService;

    public AuthenticationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> signIn(@RequestBody @Valid LoginDto loginDto) throws NotFoundException {
        try {
            return ResponseEntity.ok(loginService.signIn(loginDto));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }

}
