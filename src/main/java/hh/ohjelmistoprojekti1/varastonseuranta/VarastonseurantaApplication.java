package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

@SpringBootApplication
public class VarastonseurantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarastonseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepo, ManufacturerRepository manufacturerRepository) {
		return (args) -> {

			// testidataa valmistajsta
			Manufacturer manufacturer1 = new Manufacturer("Rukka");
			manufacturerRepository.save(manufacturer1);
			Manufacturer manufacturer2 = new Manufacturer("NORDICDOG");
			manufacturerRepository.save(manufacturer2);
			Manufacturer manufacturer3 = new Manufacturer("Ruffwear");
			manufacturerRepository.save(manufacturer3);

			// testidataa tuotteista
			productRepo.save(
					new Product("Pikku mussukan sadetakki", "Koiran sadetakki", 19.99, manufacturer1));

			productRepo.save(
					new Product("Pikku mussukan tohvelit", "Koiran tohvelit", 25, manufacturer3));

		};

	}

}
