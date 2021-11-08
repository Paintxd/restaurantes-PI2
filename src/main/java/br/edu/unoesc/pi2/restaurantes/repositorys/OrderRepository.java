package br.edu.unoesc.pi2.restaurantes.repositorys;

import br.edu.unoesc.pi2.restaurantes.models.Order;
import br.edu.unoesc.pi2.restaurantes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByClient(User user);

    @Query(value = "select fkg_gera_pedido(:en_usuario_id_clie, :en_usuario_id_func, :en_unidade_id, :en_cardapio_id, :en_qtde)", nativeQuery = true)
    Integer createOrder(@Param("en_usuario_id_clie") int clientId,
                             @Param("en_usuario_id_func") int employeeId,
                             @Param("en_unidade_id") int restaurantId,
                             @Param("en_cardapio_id") int cardapioId,
                             @Param("en_qtde") int qtde
    );
}