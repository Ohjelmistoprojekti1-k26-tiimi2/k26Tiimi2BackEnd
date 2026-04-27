package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Clothing;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ClothingRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Food;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.FoodRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;
//import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Size;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Toy;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ToyRepository;

@SpringBootApplication
public class VarastonseurantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarastonseurantaApplication.class, args);
	}

	//@Bean
	public CommandLineRunner demo(ProductRepository productRepo, ManufacturerRepository manufacturerRepository,
			FoodRepository foodRepository, ClothingRepository clothingRepository, ToyRepository toyRepository) {
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

			// lelujen valmistaja
			Manufacturer manufacturer7 = new Manufacturer("KONG");
			manufacturerRepository.save(manufacturer7);
			Manufacturer manufacturer8 = new Manufacturer("All For Paws");
			manufacturerRepository.save(manufacturer8);
			Manufacturer manufacturer9 = new Manufacturer("Pro Dogs");
			manufacturerRepository.save(manufacturer9);

			// food -data
			Food food1 = new Food("Kananappulat", 29.95, manufacturer4, "kuivaruoka", "aikuinen");
			foodRepository.save(food1);
			Food food2 = new Food("Koiranmakkara, nauta", 5.95, manufacturer5, "märkäruoka", "aikuinen");
			foodRepository.save(food2);
			Food food3 = new Food("Lammasnappulat", 20.99, manufacturer6, "kuivaruoka", "seniori");
			foodRepository.save(food3);
			Food food4 = new Food("Lammasta ja riisiä, pentunappulat", 35.95, manufacturer4, "kuivaruoka", "juniori");
			foodRepository.save(food4);

			// clothing -data
			Clothing clothing1 = new Clothing("Pikku mussukan sadetakki", 19.99, manufacturer2, Size.M, "Pinkki");
			clothingRepository.save(clothing1);
			Clothing clothing2 = new Clothing("Pikku mussukan tohvelit", 24.95, manufacturer2, Size.S, "Musta");
			clothingRepository.save(clothing2);
			Clothing clothing3 = new Clothing("Tassuttelijan pusero", 22.95, manufacturer1, Size.L, "Harmaa");
			clothingRepository.save(clothing3);
			Clothing clothing4 = new Clothing("Karvaturren talvitakki", 37.99, manufacturer3, Size.L, "Oliivin vihreä");
			clothingRepository.save(clothing4);

			// toy -data
			Toy toy1 = new Toy("Aktivointipallo", 14.95, manufacturer7, "Aktivointilelut", Size.L);
			toyRepository.save(toy1);
			Toy toy2 = new Toy("Puruluu Bone", 13.99, manufacturer9, "Purulelut", Size.M);
			toyRepository.save(toy2);
			Toy toy3 = new Toy("Possupehmo", 10.99, manufacturer8, "Pehmolelut", Size.S);
			toyRepository.save(toy3);

			// testidataa tuotteista
			// productRepo.save(
			// new Product("Pikku mussukan sadetakki", 19.99, manufacturer1));

			// productRepo.save(
			// new Product("Pikku mussukan tohvelit", 25, manufacturer3));

		};

	}

}
