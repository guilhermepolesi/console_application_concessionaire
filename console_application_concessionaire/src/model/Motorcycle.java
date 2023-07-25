package model;

import java.text.DecimalFormat;

public class Motorcycle extends Vehicle {

    private Integer engineCapacity;

    public Motorcycle () {
    }

    public Motorcycle(Long id, String model, Integer year, String manufacturer, Double price, Integer engineCapacity) {
        super(id, model, year, manufacturer, price);
        this.engineCapacity = engineCapacity;
    }

    public Motorcycle(String model, Integer year, String manufacturer, Double price, Integer engineCapacity) {
        super(model, year, manufacturer, price);
        this.engineCapacity = engineCapacity;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Vehicle: \n"
                + "Model: " + getModel() + "\n"
                + "Year:" + getYear() + "\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Engine Capacity:  " + getEngineCapacity() + "\n"
                + "Price: " + df.format(getPrice()) + "\n";

    }
}
