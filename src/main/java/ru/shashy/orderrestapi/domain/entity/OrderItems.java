package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.shashy.orderrestapi.domain.base.BaseEntity;
import ru.shashy.orderrestapi.domain.keys.OrderAndProductId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItems extends BaseEntity<OrderAndProductId> {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Products product;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Basic
    @Column(name = "unit_price", nullable = false)
    private int unitPrice;

}
