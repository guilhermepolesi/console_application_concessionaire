package view;

import db.DB;
import db.DbException;
import model.Car;
import model.Concessionaire;
import model.Vehicle;
import model.dao.impl.CarDaoJDBC;
import model.services.CarService;
import model.services.MotorcycleService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class VehicleView {

    public static void showList(Concessionaire concessionaire) {
        Scanner sc = new Scanner(System.in);
        CarService carService = new CarService();
        MotorcycleService motorcycleService = new MotorcycleService();
        System.out.println("1 - Car List | 2 - Motorcycle List | 3 - All vehicles");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                int choiceCar = 0;
                System.out.println("1 - Car by id | 2 - All cars");
                choiceCar = sc.nextInt();
                if (choiceCar == 1) {
                    System.out.println("Select car by id:");
                    System.out.println(carService.findById(sc.nextLong()));
                }
                else {
                    System.out.println("All cars:");
                    System.out.println(carService.findAll());
                }
                break;
            case 2:
                int choiceMotorcycle = 0;
                System.out.println("1 - Motorcycle by id | 2 - All motorcycles");
                choiceMotorcycle = sc.nextInt();
                if (choiceMotorcycle == 1) {
                    System.out.println("Select motorcycle by id:");
                    System.out.println(motorcycleService.findById(sc.nextLong()));
                }
                else {
                    System.out.println("All motorcycles:");
                    System.out.println(motorcycleService.findAll());
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
