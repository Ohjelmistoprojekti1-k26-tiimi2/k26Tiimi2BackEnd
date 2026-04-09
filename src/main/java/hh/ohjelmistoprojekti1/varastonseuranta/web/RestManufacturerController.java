package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;

@RestController
@RequestMapping("/api/manufacturers")
public class RestManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    public RestManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // GET kaikki valmistajat
    @GetMapping
    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }
}