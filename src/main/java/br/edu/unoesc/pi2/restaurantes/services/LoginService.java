package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.configurations.security.TokenService;
import br.edu.unoesc.pi2.restaurantes.dtos.LoginViewDto;
import br.edu.unoesc.pi2.restaurantes.dtos.TokenDto;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public LoginService(AuthenticationManager authManager, TokenService tokenService, UserRepository userRepository) {
        this.authManager = authManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    public TokenDto signIn(LoginViewDto loginViewDto) throws NotFoundException, BadCredentialsException {
        var loginData = loginViewDto.getUPAuthenticationToken();

        var authenticate = authManager.authenticate(loginData);
        String token = tokenService.generateToken(authenticate);
        var user = userRepository.findByEmail(loginViewDto.getEmail())
                .orElseThrow(() -> new NotFoundException("User email: " + loginViewDto.getEmail() + " not found"));

        return new TokenDto(token, user.getId());
    }

}
