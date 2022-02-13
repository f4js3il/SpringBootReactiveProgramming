package com.example.reactivemongocrud.Utils;

import com.example.reactivemongocrud.Model.ProductDO;
import com.example.reactivemongocrud.Payload.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ProductDO payloadToModel(Product product){
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(product,productDO);
        return productDO;
    }

    public static Product modelToPayload(ProductDO productDO){
        Product product = new Product();
        BeanUtils.copyProperties(productDO,product);
        return product;
    }
}
