package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.domain.entity.OrderItems;
import ru.shashy.orderrestapi.domain.entity.Orders;
import ru.shashy.orderrestapi.domain.entity.Products;

import java.util.Map;

public interface OrderItemsService {
    void createOrderItems(Orders orders, Map<Products, Integer> products);
}
