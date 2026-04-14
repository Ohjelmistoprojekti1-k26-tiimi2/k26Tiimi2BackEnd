package hh.ohjelmistoprojekti1.varastonseuranta.web;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.Product;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api/products")
//KAIKKI TÄMÄN CONTROLLERIN ENDPOINTIT ALKAVAT TÄLLÄ POLULLA
public class RestProductController {
    //REPOSITORIO JONKA KAUTTA HAETAAN JA TALLENNETAAN DATAA TIETOKANTAAN
    private final ProductRepository productRepository;

    public RestProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
// HAETAAN KAKKI TUOTTEET TIETOKANNASTA
    @GetMapping
    @ResponseBody
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
    //HAKEE YHDEN TUOTTEEN ID:N PERUSTEELLA
    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long productId){
        return productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Tuotetta ei löytynyt"));
    }
    //LISÄÄ UUDEN TUOTTEEN
    @PostMapping
    @ResponseBody
    public Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    //POISTAA TUOTTEEN ID:N PERUSTEELLA
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("id") Long productId) {
        productRepository.deleteById(productId);
    }

    //PÄIVITTÄÄ OLEMASSA OLEVAN TUOTTEEN
    @PutMapping("/{id}")
    @ResponseBody
    public Product editProduct(@RequestBody Product editedProduct,
                               @PathVariable("id") Long productId) {

        // ASETETAAN OIKEA ID, JOTTA OIKEA TUOTE PÄIVITTYY
        editedProduct.setProductId(productId);

        // TALLENNETAAN PÄIVITETTY TUOTE TIETOKANTAAN
        return productRepository.save(editedProduct);
    }
}
