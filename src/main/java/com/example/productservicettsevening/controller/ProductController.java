package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.dtos.ErrorResponseDto;
import com.example.productservicettsevening.dtos.GetSingleProductResponseDto;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId)
    throws NotFoundException{

       // GetSingleProductResponseDto responseDto=new GetSingleProductResponseDto();
        //responseDto.setProduct(

        MultiValueMap<String,String>headers=new LinkedMultiValueMap<>();

        headers.add(
                "auth-token", "noaccesstokey"
        );

        Optional<Product>productOptional=productService.getSingleProduct(productId);

        if(productOptional.isEmpty()){
            throw  new NotFoundException("Not a Product with Product Id " +productId);
        }

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

@PatchMapping("/{productId}")
    public Product updateAProduct(@PathVariable("productId") Long productId,
                                  @RequestBody Productdto productdto){
        Product product=new Product();
        product.setId(productdto.getId());
        product.setTitle(productdto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(productdto.getCategory());
        product.setDescription(productdto.getDescription());
        product.setPrice(productdto.getPrice());
        return productService.updateAProduct(productId, product);

    }

@DeleteMapping("/{productId}")
    public String deleteAProduct(@PathVariable("productId") Long productId){
        return "Deleting the Product "+productId;
    }


//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponseDto>handleException(Exception e){
//        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
//        errorResponseDto.setErrorMessage(e.getMessage());
//
//        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
//    }
}
