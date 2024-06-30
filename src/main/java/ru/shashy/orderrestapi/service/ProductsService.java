package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.repository.ProductsRepository;

public interface ProductsService {
    void reduceProductQuantity(Long productId, int quantity);
    Products findProductById(Long productId);
}
