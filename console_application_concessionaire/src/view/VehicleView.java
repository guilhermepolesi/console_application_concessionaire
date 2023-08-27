package view;

import db.DB;
import db.DbException;
import model.Car;
import model.Concessionaire;
import model.Vehicle;
import model.dao.impl.CarDaoJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class VehicleView {

    public static void showList(Concessionaire concessionaire, Scanner sc) {
        Connection conn = DB.getConnection();
        System.out.println("1 - Car List | 2 - Motorcycle List | 3 - All vehicles");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                CarDaoJDBC carDaoJDBC = new CarDaoJDBC(conn);
                int choiceCar = 0;
                System.out.println("1 - Car by id | 2 - All cars");
                choiceCar = sc.nextInt();
                if (choiceCar == 1) {
                    System.out.println("Select car by id:");
                    System.out.println(carDaoJDBC.findById(sc.nextLong()));
                }
                else {
                    System.out.println("All cars:");
                    System.out.println(carDaoJDBC.findAll());
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
