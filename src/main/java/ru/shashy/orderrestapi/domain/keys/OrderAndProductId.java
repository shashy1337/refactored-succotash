package ru.shashy.orderrestapi.domain.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class OrderAndProductId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "product_id", nullable = false)
    private Long productId;
}
