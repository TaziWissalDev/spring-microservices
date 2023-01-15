package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	/*CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"Enset","contact@enset-media.ma"));
			customerRepository.save(new Customer(null,"FSTM","contact@fstm.ma"));
			customerRepository.save(new Customer(null,"ENSAM","contact@ensam.ma"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}*/
	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("Hassan").email("hassan@gmail.com").build(),
							Customer.builder().name("Imane").email("imane@gmail.com").build(),
							Customer.builder().name("Mohammed").email("mohammed@gmail.com").build()
					)
			);

			customerRepository.findAll().forEach(c->{
				System.out.println(c);
			});
		};
	}

}
