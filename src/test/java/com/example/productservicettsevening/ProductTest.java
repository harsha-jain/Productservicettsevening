package com.example.productservicettsevening;

import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.repositories.CategoryRepository;
import com.example.productservicettsevening.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductTest {

 /*   @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

*//*
  @Test
  void savingProductAndCategory(){

        Category category =new Category();
        category.setName("electronic");
        Category savedCategory=categoryRepository.save(category);

        Product product=new Product();
        product.setPrice(100.0);
        product.setImageUrl("hello");
        product.setCategory(category);
        productRepository.save(product);


    }

*//*
  *//*  @Test
    @Transactional
    void fetchTypeTest(){
        Product product=productRepository.findProductById(1L);

        System.out.println("Fetching the product");
        Category category=product.getCategory();
        String name=category.getName();

    }

   *//*

    *//*
    @Test
    void deleteProduct(){
        productRepository.deleteById(1L);
    }
*//*

    @Test
    @Transactional
    @Rollback(value = false)
    //@Commit()
    void savedProductForCategory(){
       Category category=categoryRepository.findById(2L).get();

        Product product=new Product();
        product.setPrice(1011.0);
        product.setImageUrl("hiiioooo");
        product.setCategory(category);
        productRepository.save(product);

        product=new Product();
        product.setPrice(1016.0);
        product.setImageUrl("hyeoo");
        product.setCategory(category);
        productRepository.save(product);

        Category category1=new Category();
        category1.setName("Hello");
        categoryRepository.save(category1);

    }

    @Test
    @Transactional
    void getProdcutForCategory(){
       // Category category=categoryRepository.findById(2L).get();
        List<Category>categories=categoryRepository.findAllByIdIn(List.of(2L,3L));

        for(Category category:categories) {
            for (Product product : category.getProduct()) {
                System.out.println(product.getPrice());
            }
        }
    }*/

}
