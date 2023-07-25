package controller;

import model.Concessionaire;
import model.Vehicle;

public class VehicleController {

    public Concessionaire concessionaire = new Concessionaire();

    public static void showList(Concessionaire concessionaire) {
        System.out.println();

        System.out.println("Vehicle list:");
        for (Vehicle vehicle : concessionaire.getList()) {
            System.out.println(vehicle.toString());
        }
    }
}

