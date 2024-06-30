package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.domain.entity.Products;

import java.util.Map;

public interface BasketService {
    void addProduct(Long productId);
    void removeProduct(Products products);
    double getTotalPrice();
    void checkOut();
    void clear();
    Map<Products, Integer> getProducts();
}
