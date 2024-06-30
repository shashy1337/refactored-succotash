package ru.shashy.orderrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shashy.orderrestapi.domain.entity.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {
}
