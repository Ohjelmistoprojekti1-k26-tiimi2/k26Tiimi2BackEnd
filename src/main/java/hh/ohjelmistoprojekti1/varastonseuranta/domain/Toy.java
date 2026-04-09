package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Toy {

  private String toyType;

  @Enumerated(EnumType.STRING)
  private Size toySize;

  // CONSTRUCTORS
  public Toy() {
  }

  public Toy(String toyType, Size toySize) {
    this.toyType = toyType;
    this.toySize = toySize;
  }

  // SETTERS
  public void setToyType(String toyType) {
    this.toyType = toyType;
  }

  public void setToySize(Size toySize) {
    this.toySize = toySize;
  }

  // GETTERS
  public String getToyType() {
    return toyType;
  }

  public Size getToySize() {
    return toySize;
  }

  // TOSTRING
  @Override
  public String toString() {
    return "Toy [toyType=" + toyType + ", toySize=" + toySize + "]";
  }

}
