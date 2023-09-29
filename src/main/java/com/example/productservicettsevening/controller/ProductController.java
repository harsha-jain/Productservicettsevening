package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.dtos.GetSingleProductResponseDto;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

       // GetSingleProductResponseDto responseDto=new GetSingleProductResponseDto();
        //responseDto.setProduct(

        MultiValueMap<String,String>headers=new LinkedMultiValueMap<>();

        headers.add(
                "auth-token", "noaccesstokey"
        );
              ResponseEntity<Product>response=new ResponseEntity(
                      productService.getSingleProduct(productId),
                      headers,
                      HttpStatus.NOT_FOUND);
    //);
        return response;
    }


@PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody Productdto product){

            Product newProduct= productService.addNewProduct(product);
            ResponseEntity<Product>response=new ResponseEntity<>(newProduct,HttpStatus.OK);
        return response;
    }

@PutMapping("/{productId}")
    public String updateAProduct(@PathVariable("productId") Long productId){

        return "Updating the Product";
    }

@DeleteMapping("/{productId}")
    public String deleteAProduct(@PathVariable("productId") Long productId){
        return "Deleting the Product "+productId;
    }
}
