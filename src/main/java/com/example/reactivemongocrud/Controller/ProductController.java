package com.example.reactivemongocrud.Controller;

import com.example.reactivemongocrud.Payload.Product;
import com.example.reactivemongocrud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Flux<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping("/range")
    public Flux<Product> getProductInRange(
            @RequestParam("min") Double min, @RequestParam("max") Double max){
        return productService.getProductInRange(min,max);
    }

    @PostMapping("/save")
    public Mono<Product> saveProduct(@RequestBody Mono<Product> product){
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Mono<Product> saveProduct(@RequestBody Mono<Product> product, @PathVariable String id){
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }

}
