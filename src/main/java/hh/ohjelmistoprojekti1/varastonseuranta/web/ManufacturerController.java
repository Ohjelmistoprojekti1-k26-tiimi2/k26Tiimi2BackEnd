package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Manufacturer;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // uuden valmistajan lisääminen (form)
    @GetMapping("/addmanufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer"; // addmanufacturer.html
    }

    // uuden valmistajatiedon tallennus
    @PostMapping("/savemanufacturer")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:manufacturerlist"; // manufacturerlist.html
    }

    // lista valmistajista
    @GetMapping("/manufacturerlist")
    public String getManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist"; // manufacturerlist.html
    }

}
