package dev.enricogollner.dscommerce.repositories;

import dev.enricogollner.dscommerce.entities.OrderItem;
import dev.enricogollner.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
