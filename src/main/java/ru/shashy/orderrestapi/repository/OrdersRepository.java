package ru.shashy.orderrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shashy.orderrestapi.domain.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
