package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.enums.DogAge;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.enums.FoodType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Food extends Product {

  @Enumerated(EnumType.STRING)
  private FoodType foodType; // Kuivaruoka, Märkäruoka, Raakaruoka, Herkätruoat.

  @Enumerated(EnumType.STRING)
  private DogAge dogAge; // koiran ikä: Pentu, Aikuinen, Vanhus

  // CONSTRUCTORS
  public Food() {
    // yläluokan tiedot
    super();
  }

  public Food(String name, double price, Manufacturer manufacturer, FoodType foodType, DogAge age) {
    super(name, price, manufacturer);
    this.foodType = foodType;
    this.dogAge = age;
  }

  // SETTERS
  public void setFoodType(FoodType foodType) {
    this.foodType = foodType;
  }

  public void setDogAge(DogAge dogAge) {
    this.dogAge = dogAge;
  }

  // GETTERS
  public FoodType getFoodType() {
    return foodType;
  }

  public DogAge getDogAge() {
    return dogAge;
  }

  // TOSTRING
  @Override
  public String toString() {
    return super.toString() + ", foodType: " + foodType + ", dogAge: " + dogAge + ".";
  }
}
