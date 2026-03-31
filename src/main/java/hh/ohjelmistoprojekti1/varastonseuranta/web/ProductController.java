package hh.ohjelmistoprojekti1.varastonseuranta.web;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

  private final ProductRepository productRepository;

  ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("/")
  public String main(Model model) {

    model.addAttribute("products", productRepository.findAll());
    return "index"; // index.html
  }

}
