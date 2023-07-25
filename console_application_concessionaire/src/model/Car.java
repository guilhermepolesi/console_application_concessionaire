package model;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    private Integer amountPorts;

    public Car() {
    }

    public Car(Long id, String model, Integer year, String manufacturer, Double price, Integer amountPorts) {
        super(id, model, year, manufacturer, price);
        this.amountPorts = amountPorts;
    }

    public Car(String model, Integer year, String manufacturer, Double price, Integer amountPorts) {
        super(model, year, manufacturer, price);
        this.amountPorts = amountPorts;
    }

    public Integer getAmountPorts() {
        return amountPorts;
    }

    public void setAmountPorts(Integer amountPorts) {
        this.amountPorts = amountPorts;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return  "Vehicle: \n"
                + "Model: " + getModel() + "\n"
                + "Year:" + getYear() + "\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "AmountPorts: " + getAmountPorts() + "\n"
                + "Price: " + df.format(getPrice()) + "\n";


    }
}