package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  private String name;
  private String type;
  private String color;
  private String size;
  private double price;
  private String manufacturer;

  // CONSTRUCTORS

  public Product() {
  }

  public Product(String name, String type, String color, String size, double price, String manufacturer) {
    this.name = name;
    this.type = type;
    this.color = color;
    this.size = size;
    this.price = price;
    this.manufacturer = manufacturer;
  }

  // SETTERS

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

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
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

  public String getManufacturer() {
    return manufacturer;
  }

}