package br.edu.unoesc.pi2.restaurantes.mappers;

import br.edu.unoesc.pi2.restaurantes.dtos.UserDto;
import br.edu.unoesc.pi2.restaurantes.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "userRole.description", target = "role")
    UserDto userToUserDto(User user);
}
