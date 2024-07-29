package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();


    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;


    Product addNewProduct(Productdto product);


    Product updateAProduct(Long productId,Product product);

    Product replaceProduct(Long productId,Product product);

    public Page<Product> getProducts(int numberOfProducts, int offset);

    boolean deleteAProduct(Long productId);
}
