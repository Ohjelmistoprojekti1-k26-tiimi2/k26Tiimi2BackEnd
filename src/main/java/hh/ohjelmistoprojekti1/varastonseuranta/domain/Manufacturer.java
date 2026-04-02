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

    public Manufacturer (){
    }

    public Manufacturer (String manufacturer){
        this.manufacturer = manufacturer;
    }

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

    @Override
    public String toString() {
        return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturer=" + manufacturer + "]";
    }


}
