package hh.ohjelmistoprojekti1.varastonseuranta.web;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;




@RestController
@RequestMapping("/manufacturers")
public class RestManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    public RestManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // Hae kaikki valmistajat
    @GetMapping
    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    //Hae yksi valmistaja id:n perusteella
    @GetMapping("/{id}")
    public Optional<Manufacturer> getManufactererByid(@PathVariable("id") Long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }
    
    // Lisää uusi valmistaja
    @PostMapping
    public Manufacturer newManufacturer(Manufacturer newManufacturer) {
        return manufacturerRepository.save(newManufacturer);
    }

    // Poista valmistaja
    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable("id") Long manufacturerId) {
        manufacturerRepository.deleteById(manufacturerId);
    }

    // Päivitä valmistaja
    @PutMapping("/{id}")
    public Manufacturer editManufacturer(Manufacturer editedManufacturer,
                                         @PathVariable("id") Long manufacturerId) {
       
       
      // ASETETAAN OIKEA ID, JOTTA PÄIVITETÄÄN OIKEA RIVI EIKÄ LUODA UUTTA
      editedManufacturer.setManufacturerId(manufacturerId);
     // TALLENNETAAN PÄIVITETTY VALMISTAJA TIETOKANTAAN
      return manufacturerRepository.save(editedManufacturer);
    }
}