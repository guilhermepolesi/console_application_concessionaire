package model;

import java.util.ArrayList;
import java.util.List;

public class Concessionaire {

    private List<Vehicle> list = new ArrayList<>();

    private List<Car> carList = new ArrayList<>();

    private List<Motorcycle> motorcycleList = new ArrayList<>();
    public Concessionaire(){
    }
    public List<Vehicle> getList() {
        return list;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Motorcycle> getMotorcycleList() {
        return motorcycleList;
    }
}
