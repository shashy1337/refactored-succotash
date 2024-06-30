package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.shashy.orderrestapi.domain.base.BaseEntity;
import ru.shashy.orderrestapi.domain.base.TimestampCreatedUpdated;
import ru.shashy.orderrestapi.domain.enums.OrderStatus;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Embedded
    private TimestampCreatedUpdated timestampCreatedUpdated;

}