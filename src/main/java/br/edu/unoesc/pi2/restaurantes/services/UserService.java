package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.UserDto;
import br.edu.unoesc.pi2.restaurantes.dtos.UserSignupDto;
import br.edu.unoesc.pi2.restaurantes.mappers.UserMapper;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRepository;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRoleRepository;
import javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public UserDto userSignup(UserSignupDto userSignupDto) throws NotFoundException {
        var user = userSignupDto.getUser();
        var userRole = userRoleRepository.findByDescription(userSignupDto.getUserRole())
                .orElseThrow(() -> new NotFoundException("Role " + userSignupDto.getUserRole() + " not found"));
        user.setUserRole(userRole);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        var savedUser = userRepository.save(user);
        var userMapper = UserMapper.INSTANCE;

        return userMapper.userToUserDto(savedUser);
    }

    public UserDto userInfo(Integer id) throws NotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User id: " + id + " not found"));

        var userMapper = UserMapper.INSTANCE;

        return userMapper.userToUserDto(user);
    }

}
