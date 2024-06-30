package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.repository.ProductsRepository;
import ru.shashy.orderrestapi.service.ProductsService;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    @Transactional
    public void reduceProductQuantity(Long productId, int quantity) {
        int updateRows = productsRepository.reduceProductQuantity(productId, quantity);
        if (updateRows == 0) {
            throw new RuntimeException("Insufficient stock for product ID: " + productId);
        }
    }

    @Override
    public Products findProductById(Long productId) {
        return productsRepository
                .findById(productId)
                .orElse(null);
    }
}
