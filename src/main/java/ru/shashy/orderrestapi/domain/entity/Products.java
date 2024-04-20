package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.shashy.orderrestapi.domain.base.BaseEntity;
import ru.shashy.orderrestapi.domain.base.TimestampCreatedUpdated;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categoryId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Embedded
    private TimestampCreatedUpdated timestampCreatedUpdated;

}