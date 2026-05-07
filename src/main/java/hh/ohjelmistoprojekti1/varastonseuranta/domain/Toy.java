package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.enums.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Toy extends Product {

  private String toyType; // Vinkulelu, Purulelu, Aktivointilelu, Heittolelu, Älypelit, Vetolelut,
                          // Vesilelut, Pallot, Pehmolelut.

  @Enumerated(EnumType.STRING)
  private Size toySize; // lelun koko - ei koiran koko

  // CONSTRUCTORS
  public Toy() {
    // yläluokan tideot
    super();
  }

  public Toy(String name, double price, Manufacturer manufacturer, String toyType, Size toySize) {
    // yläluokan tiedot
    super(name, price, manufacturer);
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
    return super.toString() + ", [toyType=" + toyType + ", toySize=" + toySize + "]";
  }

}
