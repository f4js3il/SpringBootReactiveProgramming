package com.example.reactivemongocrud.Repository;

import com.example.reactivemongocrud.Model.ProductDO;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductDO,String> {
    Flux<ProductDO> findByPriceBetween(Range<Double> priceRange);
}
