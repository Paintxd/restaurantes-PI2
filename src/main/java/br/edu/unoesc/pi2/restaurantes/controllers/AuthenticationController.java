package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.configurations.security.TokenService;
import br.edu.unoesc.pi2.restaurantes.dtos.LoginDto;
import br.edu.unoesc.pi2.restaurantes.dtos.TokenDto;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRepository;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationManager authManager, TokenService tokenService, UserRepository userRepository) {
        this.authManager = authManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginDto loginDto) {
        var loginData = loginDto.getUPAuthenticationToken();

        try {
            var authenticate = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authenticate);
            var user = userRepository.findByEmail(loginDto.getEmail())
                    .orElseThrow(() -> new NotFoundException("user not found"));

            return ResponseEntity.ok(new TokenDto(token, user.getId()));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
