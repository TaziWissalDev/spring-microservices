package org.sid.billingservice.feign;

import org.sid.billingservice.models.Customer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
@EnableFeignClients
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}")
        Customer getCustomerById(@PathVariable(name = "id") Long id);
}
