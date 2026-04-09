package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long typeId;

  private String name;

  // CONSTRUCTORS
  public ProductType() {
  }

  public ProductType(String name) {
    this.name = name;
  }

  // SETTERIT
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public void setName(String name) {
    this.name = name;
  }

  // GETTERIT
  public Long getTypeId() {
    return typeId;
  }

  public String getName() {
    return name;
  }

  // TOSTRING
  @Override
  public String toString() {
    return "Type (Id: " + typeId + "), name: " + name + ".";
  }
}
