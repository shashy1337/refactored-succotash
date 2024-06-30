package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.entity.Orders;
import ru.shashy.orderrestapi.domain.enums.OrderStatus;
import ru.shashy.orderrestapi.repository.OrdersRepository;
import ru.shashy.orderrestapi.service.OrderService;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {


    private final OrdersRepository ordersRepository;


    @Override
    public void createOrder(Orders order) {
        ordersRepository.save(order);
    }

    @Override
    public void updateOrder(Orders order, OrderStatus status) {
        order.setStatus(status);
        ordersRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
