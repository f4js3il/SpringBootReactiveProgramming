package com.example.reactivemongocrud.Service;

import com.example.reactivemongocrud.Payload.Product;
import com.example.reactivemongocrud.Repository.ProductRepository;
import com.example.reactivemongocrud.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getProducts(){
       return productRepository.findAll().map(AppUtils::modelToPayload);
    }

    public Mono<Product> getProduct(String id){
        return productRepository.findById(id).map(AppUtils::modelToPayload);
    }

    public Flux<Product> getProductInRange(Double min, Double max){
    return productRepository.findByPriceBetween(Range.closed(min,max)).map(AppUtils::modelToPayload);
    }

    public Mono<Product> saveProduct(Mono<Product> product){
    return  product.map(AppUtils::payloadToModel)
            .flatMap(productRepository:: insert)
            .map(AppUtils::modelToPayload);
    }

    public Mono<Product> updateProduct(Mono<Product> product, String id){
         return   productRepository.findById(id)
                    .flatMap(productDO->product.map(AppUtils::payloadToModel))
                    .doOnNext(productDO -> productDO.setId(id))
                    .flatMap(productRepository::save)
                    .map(AppUtils::modelToPayload);
    }

    public Mono<Void> deleteProduct(String id){
        return productRepository.deleteById(id);
    }
}
