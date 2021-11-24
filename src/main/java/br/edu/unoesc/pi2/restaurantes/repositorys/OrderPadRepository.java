package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.OrderPad;
import br.edu.unoesc.pi2.restaurantes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPadRepository extends JpaRepository<OrderPad, Integer> {
    List<OrderPad> findByClientAndCloseDateTimeIsNull(User user);

    @Query(value = "select fkg_fecha_comanda(:en_usuario_id_clie)", nativeQuery = true)
    Integer closeOrderPad(@Param("en_usuario_id_clie") int clientId);
}