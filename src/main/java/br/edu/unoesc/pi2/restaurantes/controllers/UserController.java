package br.edu.unoesc.pi2.restaurantes.controllers;

import br.edu.unoesc.pi2.restaurantes.dtos.UserDto;
import br.edu.unoesc.pi2.restaurantes.dtos.UserSignupViewDto;
import br.edu.unoesc.pi2.restaurantes.models.User;
import br.edu.unoesc.pi2.restaurantes.services.UserService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<UserDto> userSignup(@RequestBody @Valid UserSignupViewDto userSignupViewDto, UriComponentsBuilder uriBuilder) throws NotFoundException {
        var newUser = userService.userSignup(userSignupViewDto);
        var uri = uriBuilder.path("/user/info/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<UserDto> userInfoById(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(userService.userInfo(id));
    }

    @GetMapping("info")
    public ResponseEntity<UserDto> authenticatedUserInfo() throws NotFoundException {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(userService.userInfo(user.getId()));
    }

    @GetMapping("info/all")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

}
