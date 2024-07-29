package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "selfProductService")
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Page<Product> getProducts(int numberOfProducts, int offset){
            Page<Product>products=productRepository.findAll(
                    PageRequest.of((offset/numberOfProducts),numberOfProducts,
                            Sort.by("price").descending()
                            .and(
                                    Sort.by("title").ascending()
                            ))
            );
        return products;
    }
    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        Product product=productRepository.findProductById(productId);
        if(product==null){
            throw new NotFoundException("Product does not exist");
        }
        return Optional.of(product);
    }


    @Override
    public Product addNewProduct(Productdto product) {
        return null;
    }

    @Override
    public Product updateAProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteAProduct(Long productId) {
        return false;
    }
}
