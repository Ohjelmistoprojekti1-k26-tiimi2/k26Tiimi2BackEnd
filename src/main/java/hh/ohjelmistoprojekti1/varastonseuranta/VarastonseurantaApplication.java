package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

@SpringBootApplication
public class VarastonseurantaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VarastonseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repo) {
		return (args) ->

		repo.save(new Product("Pikku mussukan sadetakki", "Koiran sadetakki", "Pinkki", "X-Large", 19.99, "Rukka"));
	}

}
