package com.example.productservicettsevening.Clients.FakeStoreApi;

import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

   public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        return Arrays.asList(l.getBody());
    }


    Optional<FakeStoreProductDto> getSingleProduct(Long productId){
        return null;
    }


    FakeStoreProductDto addNewProduct(Productdto product){
        return null;
    }


    FakeStoreProductDto updateAProduct(Long productId,Product product){
        return null;
    }

    FakeStoreProductDto replaceProduct(Long productId,Product product){
        return null;
    }
    FakeStoreProductDto deleteAProduct(Long productId){
        return null;
    }
}
