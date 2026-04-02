package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manufacturerId;

    private String manufacturer;

    // parametriton konstruktori
    public Manufacturer() {
    }

    // parametrillinen konstruktori
    public Manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // getterit ja setterit
    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // toString
    @Override
    public String toString() {
        return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturer=" + manufacturer + "]";
    }

}
