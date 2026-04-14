package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.*;

@Controller
public class ProductFormController {

    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;

    public ProductFormController(ProductRepository productRepository,
        ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    // Lomake
    @GetMapping("/addproduct2")
    public String showForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "addproduct2";
    }

    // Tuotteen tallennus
    @PostMapping("/saveproduct2")
    public String saveProduct(ProductForm form) {

        // Valmistajan valitseminen
        Manufacturer manufacturer = manufacturerRepository
                .findById(form.getManufacturerId())
                .orElse(null);

        // Luodaan vaate, jos käyttäjä valitsee tyypiksi vaatteen
        if (form.getProductType().equals("clothing")) {

            Clothing clothing = new Clothing();
            clothing.setName(form.getName());
            clothing.setPrice(form.getPrice());
            clothing.setManufacturer(manufacturer);
            clothing.setSize(Size.valueOf(form.getSize()));
            clothing.setColor(form.getColor());

            productRepository.save(clothing);

        // Luodaan ruoka, jos käyttäjä valitsee tyypiksi ruoan
            
        } else if (form.getProductType().equals("food")) {

            Food food = new Food();
            food.setName(form.getName());
            food.setPrice(form.getPrice());
            food.setManufacturer(manufacturer);
            food.setFoodType(form.getFoodType());
            food.setAge(form.getAge());

            productRepository.save(food);

        // Luodaan lelu, jos käyttäjä valitsee tyypiksi lelun


        } else if (form.getProductType().equals("toy")) {

            Toy toy = new Toy();
            toy.setName(form.getName());
            toy.setPrice(form.getPrice());
            toy.setManufacturer(manufacturer);
            toy.setToyType(form.getToyType());
            toy.setToySize(Size.valueOf(form.getToySize()));

            productRepository.save(toy);
        }

        return "redirect:/index";
    }
}