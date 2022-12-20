package com.barbel.product_service.repository;

import com.barbel.product_service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
  Optional<List<Cart>> findCartsByUid(Long uid);
}
