package dev.enricogollner.DSCommerce.repositories;

import dev.enricogollner.DSCommerce.entities.OrderItem;
import dev.enricogollner.DSCommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
