package com.example.productservicettsevening.repositories;

import com.example.productservicettsevening.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {

    Product save(Product product);

    Product findProductById(Long id);

 //   List<Product> findTitleLikeIgnoreCase(String titleLike);


 //   List<Product> findAllByPublicIs(boolean value);

  //  List<Product>findAllByPublicIsTrue();

  //  List<Product>findByImageUrlIsNullOrderByIdDesc();

 //   List<Product> findByTitleIgnoreCaseStartWith(String title);
//

//    List<Product> findProductByCategory_NameAndCategory_Id(String categoryName,Long categoryId);


    Page<Product>findAll(Pageable pageable);
}
