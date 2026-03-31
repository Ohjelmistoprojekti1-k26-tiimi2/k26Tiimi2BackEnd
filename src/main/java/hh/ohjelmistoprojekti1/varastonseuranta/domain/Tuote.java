package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tuote {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long tuoteId;

  private String tyyppi;
  private String vari;
  private int koko;
  private double hinta;
  private String valmistaja;

  public Tuote() {
  }

  public Tuote(String tyyppi, String vari, int koko, double hinta, String valmistaja) {
    this.tyyppi = tyyppi;
    this.vari = vari;
    this.koko = koko;
    this.hinta = hinta;
    this.valmistaja = valmistaja;
  }

  public Long getTuoteId() {
    return tuoteId;
  }

  public void setTuoteId(Long tuoteId) {
    this.tuoteId = tuoteId;
  }

  public String getTyyppi() {
    return tyyppi;
  }

  public void setTyyppi(String tyyppi) {
    this.tyyppi = tyyppi;
  }

  public String getVari() {
    return vari;
  }

  public void setVari(String vari) {
    this.vari = vari;
  }

  public int getKoko() {
    return koko;
  }

  public void setKoko(int koko) {
    this.koko = koko;
  }

  public double getHinta() {
    return hinta;
  }

  public void setHinta(double hinta) {
    this.hinta = hinta;
  }

  public String getValmistaja() {
    return valmistaja;
  }

  public void setValmistaja(String valmistaja) {
    this.valmistaja = valmistaja;
  }

  @Override
  public String toString() {
    return "Tuote: " + tyyppi + ", vari: " + vari + ", koko: " + koko + ", hinta: " + hinta + ", valmistaja: "
        + valmistaja + ".";
  }

}
