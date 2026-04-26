package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;

@Entity
public class Food extends Product {

  private String foodType; // kuivaruoka, märkäruoka, raakaruoka, herkätruoat.
  private String dogAge; // koiran ikä: pentu, adult, seniori

  // CONSTRUCTORS
  public Food() {
    // yläluokan tiedot
    super();
  }

  public Food(String name, double price, Manufacturer manufacturer, String foodType, String dogAge) {
    super(name, price, manufacturer);
    this.foodType = foodType;
    this.dogAge = dogAge;
  }

  // SETTERS
  public void setFoodType(String foodType) {
    this.foodType = foodType;
  }

  public void setDogAge(String dogAge) {
    this.dogAge = dogAge;
  }

  // GETTERS
  public String getFoodType() {
    return foodType;
  }

  public String getDogAge() {
    return dogAge;
  }

  // TOSTRING
  @Override
  public String toString() {
    return super.toString() + ", foodType: " + foodType + ", dogAge: " + dogAge + ".";
  }
}
