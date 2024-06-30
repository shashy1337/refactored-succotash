package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.service.BasketService;
import ru.shashy.orderrestapi.service.ProductsService;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final Map<Products, Integer> productsMap = new HashMap<>();
    private final ProductsService productsService;


    @Override
    public void addProduct(Long productId) {
        var products = productsService.findProductById(productId);
        productsMap.merge(products, 1, Integer::sum);
    }

    @Override
    public void removeProduct(Products products) {
        productsMap.computeIfPresent(products, (key, quantity) -> (quantity > 1) ? quantity - 1 : null);
    }

    @Override
    public double getTotalPrice() {
        return productsMap
                .entrySet()
                .stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    @Override
    @Transactional
    public void checkOut() {
        if (productsMap.isEmpty()) {
            throw new NullPointerException("There are no products to check out");
        }
        productsMap
                .forEach((key, value) -> productsService.reduceProductQuantity(key.getId(), value));
    }

    @Override
    public void clear() {
        productsMap.clear();
    }

    @Override
    public Map<Products, Integer> getProducts() {
        return productsMap;
    }

}
