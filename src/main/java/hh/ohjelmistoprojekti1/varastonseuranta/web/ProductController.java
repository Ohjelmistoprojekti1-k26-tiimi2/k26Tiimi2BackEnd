package hh.ohjelmistoprojekti1.varastonseuranta.web;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.ManufacturerRepository;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    model.addAttribute("products", productRepository.findAll());
    return "index"; // index.html
  }

  // uuden tuotteen lisäys (lomake)
  @GetMapping("/addproduct")
  public String addProduct(Model model) {
    model.addAttribute("product", new Product());

    // haetan kaikki valmistajat tietokannasta
    model.addAttribute("manufacturers", manufacturerRepository.findAll());
    return "addproduct"; // addproduct.html
  }

  // tuotteen tallennus - Save product
  @PostMapping("/saveproduct")
  public String save(@ModelAttribute Product product) {
    productRepository.save(product);
    return "redirect:index"; // index.html
  }

  // tuotteen muokkaus - Edit product
  @GetMapping("/editproduct/{id}")
  public String editProduct(@PathVariable("id") Long productId, Model model) {

    model.addAttribute("product", productRepository.findById(productId).orElse(null));

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
