package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.NotActiveException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class SelfProductServiceTest {

  /*  @MockBean
    private ProductRepository productRepository;

    @Autowired
    private SelfProductService productService;

    @Test
    void testGetSingleProductThrowsExceptionWhenNoSuchProduct(){

        when(productRepository.findProductById(any())).thenReturn(null);
       // when(productRepository.findProductById(any())).thenCallRealMethod();


        assertThrows(NotFoundException.class,()->productService.getSingleProduct(1L));
        // productService.getSingleProduct(1L);

    }*/
}