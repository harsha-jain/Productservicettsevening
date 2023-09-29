package com.example.productservicettsevening.services;

import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getSingleProduct(Long productId);


    Product addNewProduct(Productdto product);


    Product updateAProduct(Long productId,Product product);


    boolean deleteAProduct(Long productId);
}
