package ru.shashy.orderrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.dto.response.AppResponse;
import ru.shashy.orderrestapi.facade.ShoppingChainFacade;
import ru.shashy.orderrestapi.service.BasketService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ShoppingChainFacade shoppingChainFacade;

    @PostMapping("/basket/add/{product}")
    public AppResponse addBasket(@PathVariable(name = "product") long productId) {
        basketService.addProduct(productId);
        return new AppResponse("Product added");
    }

    @PostMapping("/basket/checkout")
    public AppResponse checkOut(){
        shoppingChainFacade.startShoppingChain();
        return new AppResponse("Checked out successfully");
    }

    @GetMapping("/basket/")
    public Map<Products, Integer> getBasket() {
        return basketService.getProducts();
    }
}
