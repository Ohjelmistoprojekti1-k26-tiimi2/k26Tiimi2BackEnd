package hh.ohjelmistoprojekti1.varastonseuranta.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;

    @NotBlank(message = "Nimitieto on pakollinen")
    private String mname;

    @JsonIgnoreProperties("manufacturer")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private List<Product> products;

    // parametriton konstruktori
    public Manufacturer() {
    }

    // parametrillinen konstruktori
    public Manufacturer(String mname) {
        this.mname = mname;
    }

    // getterit ja setterit
    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // toString
    @Override
    public String toString() {
        return "Manufacturer [manufacturerId=" + manufacturerId + ", mname=" + mname + "]";
    }

}
