package com.barbel.product_service.controller;


import com.barbel.product_service.entity.Cart;
import com.barbel.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
  @Autowired
  ProductService service;

  @GetMapping("/mylikes")
  public List<Cart> like(@RequestParam Long id) {
    return service.getMyCart(id);
  }
}
