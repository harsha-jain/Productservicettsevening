package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.Clients.AutheticationClient.AuthenticationClient;
import com.example.productservicettsevening.Clients.AutheticationClient.Dto.Role;
import com.example.productservicettsevening.Clients.AutheticationClient.Dto.SessionStatus;
import com.example.productservicettsevening.Clients.AutheticationClient.Dto.ValidateTokenResponseDto;
import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.dtos.ErrorResponseDto;
import com.example.productservicettsevening.dtos.GetProductRequestDto;
import com.example.productservicettsevening.dtos.GetSingleProductResponseDto;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.repositories.ProductRepository;
import com.example.productservicettsevening.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    private AuthenticationClient authenticationClient;
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, ProductRepository productRepository,AuthenticationClient authenticationClient){
       this.productRepository=productRepository;
        this.productService=productService;
        this.authenticationClient=authenticationClient;
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<Product>> getProduct(@RequestBody GetProductRequestDto request){
        return ResponseEntity.of(Optional.ofNullable(productService.getProducts(request.getNumberOfResult(),request.getOffset())));
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token,
    @Nullable @RequestHeader("USER_ID")Long userId){

       /* if(token==null || userId==null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        ValidateTokenResponseDto response= authenticationClient.validate(token,userId);

        if(response.getSessionStatus().equals(SessionStatus.INVALID)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }



        boolean isUserAdmin=false;
        for (Role role:response.getUserDto().getRoles()){
            if (role.getName().equals("ADMIN")){
                isUserAdmin=true;
            }
        }
        if(!isUserAdmin)
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }*/

        List<Product>products=productService.getAllProducts();
      //  products.get(0).setPrice(100.0);
        return new ResponseEntity<>(products,HttpStatus.OK);
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

          //  Product newProduct= productService.addNewProduct(product);
    Product newProduct=new Product();
    newProduct.setDescription(product.getDescription());
    newProduct.setImageUrl(product.getImage());
    newProduct.setTitle(product.getTitle());
    newProduct.setPrice(product.getPrice());
    newProduct=productRepository.save(newProduct);

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
