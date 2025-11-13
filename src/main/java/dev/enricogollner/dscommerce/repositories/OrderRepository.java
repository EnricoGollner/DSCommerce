package dev.enricogollner.dscommerce.repositories;

import dev.enricogollner.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
