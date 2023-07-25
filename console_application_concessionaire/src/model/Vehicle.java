package model;

import java.text.DecimalFormat;
import java.util.Objects;

public class Vehicle {

    private Long id;
    private String model;
    private Integer year;
    private String manufacturer;
    private Double price;

    public Vehicle() {
    }

    public Vehicle(Long id, String model, Integer year, String manufacturer, Double price) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Vehicle(String model, Integer year, String manufacturer, Double price) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id) && Objects.equals(model, vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(price, vehicle.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, year, manufacturer, price);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Vehicle: \n"
                + "Model: " + model + "\n"
                + "Year: " + year + "\n"
                + "Manufacturer: " + manufacturer + "\n"
                + "Price: " + df.format(price) + "\n";
    }
}

