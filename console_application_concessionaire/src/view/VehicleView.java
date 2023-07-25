package view;

import model.Car;
import model.Concessionaire;
import model.Vehicle;

import java.util.Scanner;

public class VehicleView {
    public static void showList(Concessionaire concessionaire) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Car List | 2 - Motorcycle List | 3 - All vehicles");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Car list:");
                for (Vehicle vehicle : concessionaire.getCarList()) {
                    System.out.println(vehicle.toString());
                }
                break;
            case 2:
                System.out.println("Motorcycle list:");
                for (Vehicle vehicle : concessionaire.getMotorcycleList()) {
                    System.out.println(vehicle.toString());
                }
                break;
            case 3:
                System.out.println("Vehicle list:");
                for (Vehicle vehicle : concessionaire.getList()) {
                    System.out.println(vehicle.toString());
                }
        }

    }
}
