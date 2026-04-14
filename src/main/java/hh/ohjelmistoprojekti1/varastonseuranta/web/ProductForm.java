package hh.ohjelmistoprojekti1.varastonseuranta.web;

public class ProductForm {

    // tuotteen tyyppi (vaate, ruoka tai lelu)
    private String productType;

    private String name;
    private double price;
    private Long manufacturerId;

    // vaate
    private String size;
    private String color;

    // ruoka
    private String foodType;
    private String age;

    // lelu
    private String toyType;
    private String toySize;

    // GETTERIT JA SETTERIT

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getToyType() {
        return toyType;
    }

    public void setToyType(String toyType) {
        this.toyType = toyType;
    }

    public String getToySize() {
        return toySize;
    }

    public void setToySize(String toySize) {
        this.toySize = toySize;
    }
}