package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    // @GetMapping("/addmanufacturer")
    // public String addManufacturer(Model model) {
    // model.addAttribute("manufacturer", new Manufacturer());
    // return "addmanufacturer"; // addmanufacturer.html
    // } --> form + listaus yhdistetty, niin tätä metodia ei tarvita

    // uuden valmistajatiedon tallennus
    @PostMapping("/savemanufacturer")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist"; // manufacturerlist.html
    }

    // lista valmistajista
    @GetMapping("/manufacturerlist")
    public String getManufacturers(Model model) {
        // haetaan lista valmistajista
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        // uuden valmistajatiedon lisäys
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerlist"; // manufacturerlist.html
    }

    // valmistajatiedon muokkaus
    @GetMapping("/editmanufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElse(null);
        model.addAttribute("manufacturer", manufacturer);
        return "editmanufacturer"; // editmanufacturer.html
    }

    @PostMapping("/editmanufacturer")
    public String updateManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist"; // manufacturerlist.html
    }

    // valmistajatiedon poisto
    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        manufacturerRepository.deleteById(manufacturerId);
        return "redirect:/manufacturerlist";
    }

}
