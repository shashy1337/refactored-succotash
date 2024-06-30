package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.shashy.orderrestapi.domain.base.BaseEntity;
import ru.shashy.orderrestapi.domain.keys.OrderAndProductId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItems {

    @EmbeddedId
    private OrderAndProductId id;

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
    private double unitPrice;

}
