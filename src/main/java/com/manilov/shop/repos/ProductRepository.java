package com.manilov.shop.repos;

import com.manilov.shop.domain.Category;
import com.manilov.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();
    Optional<Product> findById(Long Id);
    List<Product> findByCategorys(Category category);
}
