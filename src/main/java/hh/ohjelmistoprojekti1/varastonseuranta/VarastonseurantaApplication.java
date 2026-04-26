package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Food;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.FoodRepository;
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
	public CommandLineRunner demo(ProductRepository productRepo, ManufacturerRepository manufacturerRepository,
			FoodRepository foodRepository) {
		return (args) -> {

			// testidataa valmistajsta
			Manufacturer manufacturer1 = new Manufacturer("Rukka");
			manufacturerRepository.save(manufacturer1);
			Manufacturer manufacturer2 = new Manufacturer("NORDICDOG");
			manufacturerRepository.save(manufacturer2);
			Manufacturer manufacturer3 = new Manufacturer("Ruffwear");
			manufacturerRepository.save(manufacturer3);

			// ruokatuotteiden valmistajat
			Manufacturer manufacturer4 = new Manufacturer("Brit Care");
			manufacturerRepository.save(manufacturer4);
			Manufacturer manufacturer5 = new Manufacturer("Hau Hau Champion");
			manufacturerRepository.save(manufacturer5);
			Manufacturer manufacturer6 = new Manufacturer("PrimaDog");
			manufacturerRepository.save(manufacturer6);

			// food -data
			Food food1 = new Food("Kananappulat", 29.95, manufacturer4, "kuivaruoka", "aikuinen");
			foodRepository.save(food1);
			Food food2 = new Food("Koiranmakkara, nauta", 5.95, manufacturer5, "märkäruoka", "aikuinen");
			foodRepository.save(food2);
			Food food3 = new Food("Lammasnappulat", 20.99, manufacturer6, "kuivaruoka", "seniori");
			foodRepository.save(food3);
			Food food4 = new Food("Lammasta ja riisiä, pentunappulat", 35.95, manufacturer4, "kuivaruoka", "juniori");
			foodRepository.save(food4);

			// testidataa tuotteista
			// productRepo.save(
			// new Product("Pikku mussukan sadetakki", 19.99, manufacturer1));

			// productRepo.save(
			// new Product("Pikku mussukan tohvelit", 25, manufacturer3));

		};

	}

}
