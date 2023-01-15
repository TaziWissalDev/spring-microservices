package org.sid.billingservice.feign;

import org.sid.billingservice.models.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "INVENTORY-SERVICE")
@EnableFeignClients
public interface ProductItemRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);

}
