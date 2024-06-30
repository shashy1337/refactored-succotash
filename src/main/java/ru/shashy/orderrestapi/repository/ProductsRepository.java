package ru.shashy.orderrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shashy.orderrestapi.domain.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Modifying
    @Query("UPDATE Products p SET p.quantity = p.quantity - :quantity WHERE p.id = :productId AND p.quantity >= :quantity")
    int reduceProductQuantity(Long productId, int quantity);
}
