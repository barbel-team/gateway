package com.example.TeamProject01.controller;


import com.example.TeamProject01.Domain.Cart;
import com.example.TeamProject01.Domain.CartResponse;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping
public class CartController {
  @Autowired
  ProductService service;

  @GetMapping("/mylikes")
  public List<CartResponse> like(@RequestParam Long id) {
    return service.getMyCart(id);
  }


  @GetMapping("/products")
  public List<Product> getProducts() {
    return service.getProduct();
  }
}
