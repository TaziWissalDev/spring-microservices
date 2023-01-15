package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Product.class);
		return args -> {

					productRepository.saveAll(
							List.of(
									Product.builder().name("Computer").quantity(12).price(5400).build(),
									Product.builder().name("Printer").quantity(30).price(1000).build(),
									Product.builder().name("Smartphone").quantity(21).price(2300).build()
							)
					);

			productRepository.save(new Product(null,"Computer Desktop HP",9000,20));
			productRepository.save(new Product(null,"Macbook pro",45000,100));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
