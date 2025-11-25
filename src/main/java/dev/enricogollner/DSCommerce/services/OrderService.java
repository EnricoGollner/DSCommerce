package dev.enricogollner.DSCommerce.services;

import dev.enricogollner.DSCommerce.dto.OrderDTO;
import dev.enricogollner.DSCommerce.dto.OrderItemDTO;
import dev.enricogollner.DSCommerce.entities.Order;
import dev.enricogollner.DSCommerce.entities.OrderItem;
import dev.enricogollner.DSCommerce.entities.OrderStatus;
import dev.enricogollner.DSCommerce.entities.Product;
import dev.enricogollner.DSCommerce.repositories.OrderItemRepository;
import dev.enricogollner.DSCommerce.repositories.OrderRepository;
import dev.enricogollner.DSCommerce.repositories.ProductRepository;
import dev.enricogollner.DSCommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        for (OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
