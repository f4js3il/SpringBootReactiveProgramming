package com.example.reactivemongocrud.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="products")
@Getter
@Setter
public class ProductDO {

    @Id
    private String id;
    private String name;
    private Integer qty;
    private Double price;

}
