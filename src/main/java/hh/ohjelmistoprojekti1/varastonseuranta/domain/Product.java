package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  // @NotBlank(message = "Name is mandatory")
  private String name;

  private String type;
  private String color; // pois
  private String size; // pois

  // @NotBlank(message = "Price is mandatory")
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

  public Product(String name, String type, String color, String size, double price, Manufacturer manufacturer) {
    this.name = name;
    this.type = type;
    this.color = color;
    this.size = size;
    this.price = price;
    this.manufacturer = manufacturer;
  }

  // SETTERS
  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setSize(String size) {
    this.size = size;
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

  public String getType() {
    return type;
  }

  public String getColor() {
    return color;
  }

  public String getSize() {
    return size;
  }

  public double getPrice() {
    return price;
  }

  // toString
  @Override
  public String toString() {
    return "Product [productId=" + productId + ", name=" + name + ", type=" + type + ", color=" + color + ", size="
        + size + ", price=" + price + "]";
  }

}