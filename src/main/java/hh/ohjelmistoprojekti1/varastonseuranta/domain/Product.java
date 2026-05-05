package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// annotaation avulla kerrotaan JPA:lle miten perintä toimii
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @NotBlank(message = "Nimitieto on pakollinen")
  private String name;

  private String productType;

  @NotNull(message = "Hintatieto on pakollinen")
  @DecimalMin(value = "0.0")
  private double price;

  @JsonIgnoreProperties("products")
  @ManyToOne // suhde manufacturer -entityyn
  @JoinColumn(name = "manufacturerId")
  private Manufacturer manufacturer;

  // getterit ja setterit manufacturerille
  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  // CONSTRUCTORS
  public Product() {
  }

  public Product(String name, double price, Manufacturer manufacturer) {
    this.name = name;
    this.price = price;
    this.manufacturer = manufacturer;
  }

  // SETTERS
  public void setProductType(String productType) {
    this.productType = productType;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // GETTERS
  public Long getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getProductType() {
    return productType;
  }

  // toString
  @Override
  public String toString() {
    return "Product (productId: " + productId + "), name: " + name
        + ", product type: " + productType + ", price: " + price + ".";
  }

}