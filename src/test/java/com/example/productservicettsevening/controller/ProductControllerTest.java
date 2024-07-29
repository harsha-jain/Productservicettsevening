package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.repositories.ProductRepository;
import com.example.productservicettsevening.services.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {


   /* @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

 @Test
    void testAbsShouldReturnCorrectValue(){
        int i=Math.abs(-2);
        assert (i==2);
 }
    @Test
    void getAllProductShouldReturnEmptyListWhenNoProduct(){

//        List<Product>p=new ArrayList<>();
//        Product p1=new Product();
//        p1.setPrice(109.95);
//        p.add(p1);
//
//        when(productService.getAllProducts()).thenReturn(p);
//
//        List<Product>products=productController.getAllProducts("1234").getBody();
//       // assert products.get(0).getPrice()==109.95;
//
//        assertThat(products.get(0).getPrice())
//                .isEqualTo(109.95)
//                .isGreaterThan(100)
//                .isLessThan(200)
//                .isPositive();
//
//        assertThat("hello")
//                .isEqualTo("hi");
//        assertThat(new Object())
//                .isInstanceOf(ProductRepository.class);
  }
*/

}