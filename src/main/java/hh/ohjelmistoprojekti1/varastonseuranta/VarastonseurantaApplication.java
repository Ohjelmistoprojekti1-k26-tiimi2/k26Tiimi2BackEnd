package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

@SpringBootApplication
public class VarastonseurantaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VarastonseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepo, ManufacturerRepository manufacturerRepo) {
		return (args) -> {

			// Manufacturer manufacturer1

			productRepo.save(
					new Product("Pikku mussukan sadetakki", "Koiran sadetakki", "Pinkki", "X-Large", 19.99, "Rukka"));
			productRepo
					.save(new Product("Pikku mussukan tohvelit", "Koiran tohvelit", "Musta", "X-Small", 25, "Rukka"));
		};

	}

}
