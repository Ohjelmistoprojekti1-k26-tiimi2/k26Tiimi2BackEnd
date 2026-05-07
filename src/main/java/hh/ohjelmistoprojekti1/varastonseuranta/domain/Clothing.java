package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.enums.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Clothing extends Product {

  @Enumerated(EnumType.STRING)
  private Size clothingSize;

  private String color;

  // CONSTRUCTORS
  public Clothing() {
    // yläluokan tiedot
    super();
  }

  public Clothing(String name, double price, Manufacturer manufacturer, Size size, String color) {
    super(name, price, manufacturer);
    this.clothingSize = size;
    this.color = color;
  }

  // SETTERS
  public void setClothingSize(Size clothingSize) {
    this.clothingSize = clothingSize;
  }

  public void setColor(String color) {
    this.color = color;
  }

  // GETTERS
  public Size getClothingSize() {
    return clothingSize;
  }

  public String getColor() {
    return color;
  }

  // TOSTRING
  @Override
  public String toString() {
    return super.toString() + ", size: " + clothingSize + ", color: " + color + ".";
  }
}
