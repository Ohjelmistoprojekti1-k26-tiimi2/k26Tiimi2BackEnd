package hh.ohjelmistoprojekti1.varastonseuranta.domain;

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
  }

  public Clothing(Size size, String color) {
    this.clothingSize = size;
    this.color = color;
  }

  // SETTERS
  public void setSize(Size size) {
    this.clothingSize = size;
  }

  public void setColor(String color) {
    this.color = color;
  }

  // GETTERS
  public Size getSize() {
    return clothingSize;
  }

  public String getColor() {
    return color;
  }

  // TOSTRING
  @Override
  public String toString() {
    return "Clothing: size: " + clothingSize + ", color: " + color + ".";
  }
}
