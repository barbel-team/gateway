package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Cart;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
  Optional<List<Cart>> findCartsByUid(Long uid);
}
