package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;

@Entity
public class Food extends Product {

  private String foodType; // kuivaruoka, märkäruoka, raakaruoka, herkätruoat.
  private String dogAge; // koiran ikä: pentu, adult, seniori

  // CONSTRUCTORS
  public Food() {
  }

  public Food(String foodType, String age) {
    this.foodType = foodType;
    this.dogAge = age;
  }

  // SETTERS
  public void setFoodType(String foodType) {
    this.foodType = foodType;
  }

  public void setAge(String age) {
    this.dogAge = age;
  }

  // GETTERS
  public String getFoodType() {
    return foodType;
  }

  public String getAge() {
    return dogAge;
  }

  // TOSTRING
  @Override
  public String toString() {
    return "Food: foodType: " + foodType + ", age: " + dogAge + ".";
  }
}
