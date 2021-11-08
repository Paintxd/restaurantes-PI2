package br.edu.unoesc.pi2.restaurantes.services;

import br.edu.unoesc.pi2.restaurantes.dtos.UserDto;
import br.edu.unoesc.pi2.restaurantes.dtos.UserSignupViewDto;
import br.edu.unoesc.pi2.restaurantes.mappers.UserMapper;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRepository;
import br.edu.unoesc.pi2.restaurantes.repositorys.UserRoleRepository;
import javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public UserDto userSignup(UserSignupViewDto userSignupViewDto) throws NotFoundException {
        var user = userSignupViewDto.getUser();
        var userRole = userRoleRepository.findByDescription(userSignupViewDto.getUserRole())
                .orElseThrow(() -> new NotFoundException("Role " + userSignupViewDto.getUserRole() + " not found"));
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

    public List<UserDto> findAll() {
        var userMapper = UserMapper.INSTANCE;

        return userRepository.findAll()
                .parallelStream()
                .map(userMapper::userToUserDto)
                .toList();
    }

}
