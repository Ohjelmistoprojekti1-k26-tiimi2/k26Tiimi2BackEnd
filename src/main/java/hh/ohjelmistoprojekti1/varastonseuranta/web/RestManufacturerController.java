package hh.ohjelmistoprojekti1.varastonseuranta.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;

@Controller
/*@Controller kertoo Springille, että tämä on controller-luokka
normaalisti palauttaisi HTML, mutta @RTesponceBody muuttaa sen JSONIKSI */


@RequestMapping("/api/manufacturers")
public class RestManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    public RestManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // Hae kaikki valmistajat
    @GetMapping
    @ResponseBody
    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    //Hae yksi valmistaja id:n perusteella
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Manufacturer> getManufactererByid(@PathVariable("id") Long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }
    
    // Lisää uusi valmistaja
    @PostMapping
    @ResponseBody
    public Manufacturer newManufacturer(@RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.save(newManufacturer);
    }

    // Poista valmistaja
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteManufacturer(@PathVariable("id") Long manufacturerId) {
        manufacturerRepository.deleteById(manufacturerId);
    }

    // Päivitä valmistaja
    @PutMapping("/{id}")
    @ResponseBody
    public Manufacturer editManufacturer(@RequestBody Manufacturer editedManufacturer,
                                         @PathVariable("id") Long manufacturerId) {
       
       
      // ASETETAAN OIKEA ID, JOTTA PÄIVITETÄÄN OIKEA RIVI EIKÄ LUODA UUTTA
      editedManufacturer.setManufacturerId(manufacturerId);
     // TALLENNETAAN PÄIVITETTY VALMISTAJA TIETOKANTAAN
      return manufacturerRepository.save(editedManufacturer);
    }
}