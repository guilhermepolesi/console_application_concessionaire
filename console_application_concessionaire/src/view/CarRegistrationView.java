package view;


import controller.RegistrationController;
import model.dao.impl.CarDaoJDBC;
import db.DB;
import model.Car;
import model.Concessionaire;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRegistrationView extends RegistrationView {

    private Connection conn;

    public CarRegistrationView() {
    }

    public void carRegistrationView(Scanner sc) {
        boolean validInput = false;
        while (!validInput) {
            try {
                conn = DB.getConnection();
                Car car = new Car();
                System.out.println("Car registration");
                System.out.print("Car model: ");
                car.setModel(sc.nextLine());
                System.out.print("Car year: ");
                car.setYear(sc.nextInt());
                System.out.print("Car manufacturer: ");
                sc.nextLine();
                car.setManufacturer(sc.nextLine());
                System.out.print("Car price: ");
                car.setPrice(sc.nextDouble());
                System.out.print("Car amount ports: ");
                car.setAmountPorts(sc.nextInt());
                CarDaoJDBC carDaoJDBC = new CarDaoJDBC(conn);
                carDaoJDBC.insert(car);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}
