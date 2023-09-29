package com.example.productservicettsevening.services;

import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<List>l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                List.class
        );
        List<Product>answer=new ArrayList<>();
        for(Object obj:l.getBody()){
            HashMap<String,Object>hm= (HashMap<String,Object>)obj;

            Product product=new Product();
            product.setId(Long.valueOf((Integer)hm.get("id")));
            product.setTitle((String) hm.get("title"));
            product.setPrice(Double.valueOf(hm.get("price").toString()));
            product.setDescription((String) hm.get("description"));
            Category category=new Category();
            category.setName((String) hm.get("category"));
            product.setCategory(category);
            product.setImageUrl((String) hm.get("image"));
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<Productdto>response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",Productdto.class,productId);
        Productdto productdto=response.getBody();

        Product product=new Product();
        product.setId(productdto.getId());
        product.setTitle(productdto.getTitle());
        product.setPrice(productdto.getPrice());
        product.setDescription(productdto.getDescription());
        Category category=new Category();
        category.setName(productdto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productdto.getImage());

        return product;
    }

    @Override
    public Product addNewProduct(Productdto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<Productdto>response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                Productdto.class
        );
        Productdto productdto=response.getBody();

        Product product1=new Product();
        product1.setId(productdto.getId());
        product1.setTitle(productdto.getTitle());
        product1.setPrice(productdto.getPrice());
        product1.setDescription(productdto.getDescription());
        Category category=new Category();
        category.setName(productdto.getCategory());
        product1.setCategory(category);
        product1.setImageUrl(productdto.getImage());

        return product1;
    }

    @Override
    public Product updateAProduct(Long productId,Product product) {
            return product;
    }

    @Override
    public boolean deleteAProduct(Long productId) {
        return false;
    }
}
