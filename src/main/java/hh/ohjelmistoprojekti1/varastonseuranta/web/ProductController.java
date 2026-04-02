package hh.ohjelmistoprojekti1.varastonseuranta.web;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

  private final ProductRepository productRepository;

  ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping({ "/", "/index" })
  public String main(Model model) {

    model.addAttribute("products", productRepository.findAll());
    return "index"; // index.html
  }

  // uuden tuotteen lisäys (lomake)
  @GetMapping("/addproduct")
  public String addProduct(Model model) {
    model.addAttribute("product", new Product());
    return "addproduct"; // addproduct.html
  }

  // tuotteen tallennus
  @PostMapping("/saveproduct")
  public String save(@ModelAttribute Product product) {
    productRepository.save(product);
    return "redirect:/index"; // index.html
  }

  // tuotteen muokkaus
  @GetMapping("/editproduct/{id}")
  public String editProduct(@PathVariable("id") Long productId, Model model) {

    model.addAttribute("product", productRepository.findById(productId).orElse(null));
    return "editproduct"; // editproduct.html
  }

}
