package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Cart;
import com.example.TeamProject01.Domain.CartResponse;
import com.example.TeamProject01.Domain.CartResponseMapper;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.repository.CartRepository;
import com.example.TeamProject01.repository.ProductRepository;
import com.example.TeamProject01.repository.ProductRepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductService {

    private ProductRepositoryInterface repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;
    public Product save(Product p){

        p.setPrd_name(p.getPrd_name());
        p.setPrd_price(p.getPrd_price());
        p.setPrd_cmp(p.getPrd_cmp());
        p.setPrd_type(p.getPrd_type());
        p.setPrd_ment(p.getPrd_ment());
        p.setPrd_sales(p.getPrd_sales());

        return productRepository.save(p);
    }

    public List<CartResponse> getMyCart(Long uid) {
        List<Cart> carts = cartRepository.findCartsByUid(uid).orElseThrow(NoSuchElementException::new);
        List<CartResponse> cartResponses = new ArrayList<>();

        for(Cart cart : carts) {
            Product p = productRepository.findById(cart.getOrdnum()).orElseThrow(NoSuchElementException::new);
            cartResponses.add(CartResponseMapper.mapping(cart, p));
            System.out.println(p.getUid());
            System.out.println(cart.getUid());
        }
        return cartResponses;

    }


    public void uploadImage(ProductImage pi){
        repository.saveProductImage(pi);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Autowired
    public ProductService(ProductRepositoryInterface repository){
        this.repository = repository;
    }


}
