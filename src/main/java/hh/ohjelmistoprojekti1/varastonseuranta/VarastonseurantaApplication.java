package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.TuoteRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Tuote;


@SpringBootApplication
public class VarastonseurantaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VarastonseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (TuoteRepository repo){
		return (args) ->
		
		repo.save(new Tuote("Koiran sadetakki", "Pinkki", "X-Large", 19.99, "Rukka"));
	}


}
