package ru.shashy.orderrestapi.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.base.TimestampCreatedUpdated;
import ru.shashy.orderrestapi.domain.entity.Orders;
import ru.shashy.orderrestapi.domain.enums.OrderStatus;
import ru.shashy.orderrestapi.domain.usercontext.UserContext;
import ru.shashy.orderrestapi.service.BasketService;
import ru.shashy.orderrestapi.service.OrderItemsService;
import ru.shashy.orderrestapi.service.OrderService;
import ru.shashy.orderrestapi.service.UserService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShoppingChainFacade {

    private final OrderService orderService;
    private final BasketService basketService;
    private final UserContext userContext;
    private final UserService userService;
    private final OrderItemsService orderItemsService;

    @Transactional
    public void startShoppingChain() {
        basketService.checkOut();
        var order = Orders
                .builder()
                .status(OrderStatus.ACCEPTED)
                .user(userService.findByUsername(userContext.getAuthUser()))
                .totalPrice(basketService.getTotalPrice())
                .timestampCreatedUpdated(new TimestampCreatedUpdated(LocalDateTime.now(), LocalDateTime.now()))
                .build();
        orderService.createOrder(order);
        orderItemsService.createOrderItems(order, basketService.getProducts());
    }
}
