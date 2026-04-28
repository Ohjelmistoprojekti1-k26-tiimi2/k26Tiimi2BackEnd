package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Food extends Product {

  private String foodType; // kuivaruoka, märkäruoka, raakaruoka, herkätruoat.

  @Enumerated(EnumType.STRING)
  private DogAge dogAge; // koiran ikä: pentu, adult, seniori

  // CONSTRUCTORS
  public Food() {
    // yläluokan tiedot
    super();
  }

  public Food(String name, double price, Manufacturer manufacturer, String foodType, DogAge age) {
    super(name, price, manufacturer);
    this.foodType = foodType;
    this.dogAge = age;
  }

  // SETTERS
  public void setFoodType(String foodType) {
    this.foodType = foodType;
  }

  public void setDogAge(DogAge dogAge) {
    this.dogAge = dogAge;
  }

  // GETTERS
  public String getFoodType() {
    return foodType;
  }

  public DogAge getDogAge() {
    return dogAge;
  }

  // TOSTRING
  @Override
  public String toString() {
    return super.toString() + ", foodType: " + foodType + ", age: " + dogAge + ".";
  }
}
