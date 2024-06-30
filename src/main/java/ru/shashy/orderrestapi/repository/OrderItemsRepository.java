package ru.shashy.orderrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shashy.orderrestapi.domain.entity.OrderItems;
import ru.shashy.orderrestapi.domain.keys.OrderAndProductId;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, OrderAndProductId> {
}
