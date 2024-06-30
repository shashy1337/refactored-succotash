package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.domain.entity.Orders;
import ru.shashy.orderrestapi.domain.enums.OrderStatus;

public interface OrderService {
    void createOrder(Orders order);
    void updateOrder(Orders order, OrderStatus status);
    void deleteOrder(Long orderId);
}
