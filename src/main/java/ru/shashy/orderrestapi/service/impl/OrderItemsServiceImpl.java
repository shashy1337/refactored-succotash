package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.entity.OrderItems;
import ru.shashy.orderrestapi.domain.entity.Orders;
import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.domain.keys.OrderAndProductId;
import ru.shashy.orderrestapi.repository.OrderItemsRepository;
import ru.shashy.orderrestapi.service.OrderItemsService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;

    @Override
    @Transactional
    public void createOrderItems(Orders orders, Map<Products, Integer> products) {
        var list = products.entrySet()
                .stream()
                .map(entry ->
                        OrderItems.builder()
                                .id(new OrderAndProductId(orders.getId(), entry.getKey().getId()))
                                .order(orders)
                                .product(entry.getKey())
                                .quantity(entry.getValue())
                                .unitPrice(entry.getKey().getPrice())
                                .build())
                .toList();
        orderItemsRepository.saveAll(list);
    }

}
