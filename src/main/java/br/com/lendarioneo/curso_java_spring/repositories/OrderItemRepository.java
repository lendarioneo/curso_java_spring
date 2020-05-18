package br.com.lendarioneo.curso_java_spring.repositories;

import br.com.lendarioneo.curso_java_spring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
