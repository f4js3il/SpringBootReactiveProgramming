package com.example.reactivemongocrud.Payload;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;
    private String name;
    private Integer qty;
    private Double price;
}
