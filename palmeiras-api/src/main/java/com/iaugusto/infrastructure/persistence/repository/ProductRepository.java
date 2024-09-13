package com.iaugusto.infrastructure.persistence.repository;

import com.iaugusto.infrastructure.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
