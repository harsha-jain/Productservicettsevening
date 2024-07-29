 package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Clients.FakeStoreApi.FakeStoreClient;
import com.example.productservicettsevening.Clients.FakeStoreApi.FakeStoreProductDto;
import com.example.productservicettsevening.dtos.Productdto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service(value = "fakeStoreProductService")
//@Primary
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    private Map<Long,Object>fakestoreProducts=new HashMap<>();

   // private RedisTemplate<Long,Object>redisTemplate;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient /*,RedisTemplate<Long,Object> redisTemplate*/){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
       // this.redisTemplate=redisTemplate;
    }

    private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate=restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (restTemplate.execute(url,httpMethod, requestCallback, responseExtractor, uriVariables));
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        return product;
    }
    @Override
    public List<Product> getAllProducts() {
List<FakeStoreProductDto>fakeStoreProductDtoList=fakeStoreClient.getAllProducts();
        List<Product>answer=new ArrayList<>();

        for(FakeStoreProductDto productDto:fakeStoreProductDtoList){
         //   HashMap<String,Object>hm= (HashMap<String,Object>)obj;
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
      //  FakeStoreProductDto fakeStoreProductDto=(FakeStoreProductDto) redisTemplate.opsForHash().get(productId,"Product");
//        if(fakeStoreProductDto!=null){
//            return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
//        }
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>response=restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,productId);

        FakeStoreProductDto productDto=response.getBody();
      //fakestoreProducts.put(productId,productDto);
       // redisTemplate.opsForHash().put(productId,"products",productDto);

        if(productDto==null){
             return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductDtoToProduct(productDto));
    }

    @Override
    public Product addNewProduct(Productdto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class
        );
        FakeStoreProductDto productDto=response.getBody();

        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product updateAProduct(Long productId,Product product) {
        RestTemplate restTemplate=restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

//        ResponseEntity<FakeStoreProductDto>fakeStoreProductDtoResponseEntity=requestForEntity(
//                HttpMethod.PATCH,
//                "http://fakestoreapi.com/products/{id}",
//                fakeStoreProductDto,
//                FakeStoreProductDto.class,
//                productId
//        );
        FakeStoreProductDto fakeStoreProductDtoResponse=restTemplate.patchForObject(
                "http://fakestoreapi.com/products/{id}",
                    fakeStoreProductDto,
                    FakeStoreProductDto.class,
                    productId
      );
      //  return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponse);

    }
    public  Product replaceProduct(Long productId, Product product){

        return product;
    }
    @Override
    public boolean deleteAProduct(Long productId) {
        return false;
    }

    @Override
    public Page<Product> getProducts(int numberOfProducts, int offset) {
        return null;
    }
}
