package hh.ohjelmistoprojekti1.varastonseuranta.web;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Clothing;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Food;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Size;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Toy;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

  private final ManufacturerRepository manufacturerRepository;
  private final ProductRepository productRepository;

  ProductController(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
    this.productRepository = productRepository;
    this.manufacturerRepository = manufacturerRepository;
  }

  // etusivu / lista tuotteista
  @GetMapping({ "/", "/index" })
  public String main(Model model) {
    // haetaan kaikki tuotteet
    model.addAttribute("products", productRepository.findAll());
    return "index"; // index.html
  }

  // uuden tuotteen lisäys (lomake)
  @GetMapping("/addproduct")
  public String addProduct(Model model) {
    // model.addAttribute("productForm", new ProductForm());

    // haetan kaikki valmistajat tietokannasta
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "addproduct"; // addproduct.html
  }

  // tuotteen tallennus - Save product
  @PostMapping("/saveproduct")
  public String save(@ModelAttribute Product product) {
    productRepository.save(product);
    return "redirect:/index"; // index.html
  }

  // haetaan lelun lisäykseen formipohja
  @GetMapping("/addtoy")
  public String addToy(Model model) {
    model.addAttribute("toy", new Toy());
    model.addAttribute("toySizes", Size.values());
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "addtoy"; // addtoy.html
  }

  // lelun tallennus (from)
  @PostMapping("/savetoy")
  public String saveToy(@Valid @ModelAttribute Toy toy, BindingResult bindingResult, Model model) {

    // virheidenkäsittely validoinnin yhteydessä
    if (bindingResult.hasErrors()) {
      model.addAttribute("products", productRepository.findAll());
      return "addtoy"; // addtoy.html
    }

    // asetetaan tuotteen tyypiksi lelu
    toy.setProductType("Lelu");

    productRepository.save(toy);
    return "redirect:/index";
  }

  // haetaan ruuan lisäykseen formipohja
  @GetMapping("/addfood")
  public String addFood(Model model) {
    model.addAttribute("food", new Food());
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "addfood"; // addfood.html
  }

  // ruuan tallennus (from)
  @PostMapping("/savefood")
  public String saveFood(@Valid @ModelAttribute Food food, BindingResult bindingResult, Model model) {

    // virheidenkäsittely validoinnin yhteydessä
    if (bindingResult.hasErrors()) {
      model.addAttribute("products", productRepository.findAll());
      return "addfood"; // addfood.html
    }

    // asetetaan tuotteen tyypiksi ruoka
    food.setProductType("Ruoka");

    productRepository.save(food);
    return "redirect:/index";
  }

  // haetaan vaatteen lisäykseen formipohja
  @GetMapping("/addclothing")
  public String addClothing(Model model) {
    model.addAttribute("clothing", new Clothing());
    // haetaan valmistajatiedot
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    // haetaan kokotiedot
    model.addAttribute("sizes", Size.values());
    return "addclothing"; // addclothing.html
  }

  // vaatteen tallennus (from)
  @PostMapping("/saveclothing")
  public String saveClothing(@Valid @ModelAttribute Clothing clothing, BindingResult bindingResult, Model model) {

    // virheidenkäsittely validoinnin yhteydessä
    if (bindingResult.hasErrors()) {
      model.addAttribute("products", productRepository.findAll());
      return "addclothing"; // addclothing.html
    }

    // asetetaan tuotteen tyypiksi vaate
    clothing.setProductType("Vaate");

    productRepository.save(clothing);
    return "redirect:/index";
  }

  @GetMapping("/editclothing/{id}")
  public String editClothing(@PathVariable("id") Long productId, Model model) {
    Product product = productRepository.findById(productId).orElse(null);

    if (!(product instanceof Clothing clothing)) {
      return "redirect:/index";
    }

    model.addAttribute("clothing", clothing);
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    model.addAttribute("sizes", Size.values());
    return "editclothing";
  }

  @GetMapping("/editfood/{id}")
  public String editFood(@PathVariable("id") Long productId, Model model) {
    Product product = productRepository.findById(productId).orElse(null);

    if (!(product instanceof Food food)) {
      return "redirect:/index";
    }

    model.addAttribute("food", food);
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "editfood";
  }

  @GetMapping("/edittoy/{id}")
  public String editToy(@PathVariable("id") Long productId, Model model) {
    Product product = productRepository.findById(productId).orElse(null);

    if (!(product instanceof Toy toy)) {
      return "redirect:/index";
    }

    model.addAttribute("toy", toy);
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    model.addAttribute("sizes", Size.values());
    return "edittoy";
  }

  // tuotteen muokkaus - Edit product
  @GetMapping("/editproduct/{id}")
  public String editProduct(@PathVariable("id") Long productId, Model model) {

    Product product = productRepository.findById(productId).orElse(null);
    model.addAttribute("product", product);

    // haetan kaikki valmistajat tietokannasta
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "editproduct"; // editproduct.html
  }

  // poista tuote - Delete product
  @GetMapping("/deleteproduct/{id}")
  public String deleteProduct(@PathVariable("id") Long productId, Model model) {
    productRepository.deleteById(productId);

    return "redirect:/index"; // index.html
  }

}