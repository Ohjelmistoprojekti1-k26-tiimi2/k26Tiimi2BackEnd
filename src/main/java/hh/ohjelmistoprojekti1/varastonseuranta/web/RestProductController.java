package hh.ohjelmistoprojekti1.varastonseuranta.web;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;


@RestController
@RequestMapping("/products")
//KAIKKI TÄMÄN CONTROLLERIN ENDPOINTIT ALKAVAT TÄLLÄ POLULLA
public class RestProductController {
    //REPOSITORIO JONKA KAUTTA HAETAAN JA TALLENNETAAN DATAA TIETOKANTAAN
    private final ProductRepository productRepository;

    public RestProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
// HAETAAN KAKKI TUOTTEET TIETOKANNASTA
    @GetMapping
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
    //HAKEE YHDEN TUOTTEEN ID:N PERUSTEELLA
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long productId){
        return productRepository.findById(productId);
    }
    //LISÄÄ UUDEN TUOTTEEN
    @PostMapping
    public Product newProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    //POISTAA TUOTTEEN ID:N PERUSTEELLA
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productRepository.deleteById(productId);
    }

    //PÄIVITTÄÄ OLEMASSA OLEVAN TUOTTEEN
    @PutMapping("/{id}")
    public Product editProduct(Product editedProduct,
                               @PathVariable("id") Long productId) {

        // ASETETAAN OIKEA ID, JOTTA OIKEA TUOTE PÄIVITTYY
        editedProduct.setProductId(productId);

        // TALLENNETAAN PÄIVITETTY TUOTE TIETOKANTAAN
        return productRepository.save(editedProduct);
    }
}
