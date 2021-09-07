package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByDescription(String description);
}
