package hh.ohjelmistoprojekti1.varastonseuranta.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class RestProductController {

    private final ProductRepository ProductRepository;

    public RestProductController(ProductRepository productRepository) {
        this.ProductRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return ProductRepository.findByName("products");
    }
}