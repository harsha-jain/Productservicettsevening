package com.example.productservicettsevening.repositories;

import com.example.productservicettsevening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {

    Product save(Product product);


}
