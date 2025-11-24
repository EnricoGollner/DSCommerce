package dev.enricogollner.DSCommerce.repositories;

import dev.enricogollner.DSCommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
