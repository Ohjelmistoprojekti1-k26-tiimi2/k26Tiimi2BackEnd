package hh.ohjelmistoprojekti1.varastonseuranta.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Toy;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ToyRepository;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Food;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.FoodRepository;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Clothing;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ClothingRepository;

@RestController
@RequestMapping("/api")
public class RestProductController {

    private final ProductRepository productRepository;
    private final ToyRepository toyRepository;
    private final FoodRepository foodRepository;
    private final ClothingRepository clothingRepository;

    public RestProductController(ProductRepository productRepository,
                                 ToyRepository toyRepository,
                                 FoodRepository foodRepository,
                                 ClothingRepository clothingRepository) {
        this.productRepository = productRepository;
        this.toyRepository = toyRepository;
        this.foodRepository = foodRepository;
        this.clothingRepository = clothingRepository;
    }

    // KAIKKI TUOTTEET
    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    // YKSI TUOTE ID:N PERUSTEELLA
    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long productId) {
        return productRepository.findById(productId);
    }

    // LISÄÄ UUSI TUOTE
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    // POISTA TUOTE
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productRepository.deleteById(productId);
    }

    // PÄIVITÄ TUOTE
    @PutMapping("/products/{id}")
    public Product editProduct(@RequestBody Product editedProduct,
                               @PathVariable("id") Long productId) {
        editedProduct.setProductId(productId);
        return productRepository.save(editedProduct);
    }

    // LELUT
    @GetMapping("/toys")
    public Iterable<Toy> getToys() {
        return toyRepository.findAll();
    }

    // RUOAT
    @GetMapping("/foods")
    public Iterable<Food> getFoods() {
        return foodRepository.findAll();
    }

    // VAATTEET
    @GetMapping("/clothes")
    public Iterable<Clothing> getClothes() {
        return clothingRepository.findAll();
    }
}