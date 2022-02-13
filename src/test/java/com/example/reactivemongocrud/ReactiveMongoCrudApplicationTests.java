package com.example.reactivemongocrud;

import com.example.reactivemongocrud.Controller.ProductController;
import com.example.reactivemongocrud.Payload.Product;
import com.example.reactivemongocrud.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
class ReactiveMongoCrudApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductService productService;

    @Test
    public void addProductTest(){
        Mono<Product> productDtoMono=Mono.just(new Product("102","mobile",1, 10000.0));
        when(productService.saveProduct(productDtoMono)).thenReturn(productDtoMono);

        webTestClient.post().uri("/products/save")
                .body(Mono.just(productDtoMono),Product.class)
                .exchange()
                .expectStatus().isOk();//200

    }

}
