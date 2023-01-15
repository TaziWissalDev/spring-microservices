package org.sid.billingservice;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.models.Customer;
import org.sid.billingservice.models.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductItemRestClient productItemRestClient
    ){
        return args -> {
          /*  Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill =billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
            System.out.println("-------------------------------");
            System.out.println(customer.getId());
            System.out.println(customer.getName());
            System.out.println(customer.getEmail());
            PagedModel<Product> productPagedModel = productItemRestClient.pageProducts();
            productPagedModel.forEach( p ->{
                System.out.println(p.toString());
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1 + new Random().nextInt(100));
                productItem.setBill(bill);
                productItem.setProductID(p.getId());
                productItem.setProduct(p);
                productItem.setProductName(p.getName());
                productItemRepository.save(productItem);
                System.out.println(productItem.toString());
            });*/

            Collection<Product> products = productItemRestClient.pageProducts().getContent();
            Long customerId = 1L;
            Customer customer = customerRestClient.getCustomerById(customerId);
            if(customer == null) throw new RuntimeException("customer not found!!");
            Bill bill = new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerID(customerId);
            bill.setCustomer(customer);
            Bill savedBill= billRepository.save(bill);
            PagedModel<Product> productPagedModel = productItemRestClient.pageProducts();
            products.forEach(p->{
                ProductItem productItem=new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductID(p.getId());
                productItem.setQuantity(1 + new Random().nextInt(100));
                productItem.setPrice(p.getPrice());
                productItem.setDiscount(Math.random());
                productItemRepository.save(productItem);

            });
        };
    }

}
