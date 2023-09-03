package view;


import controller.RegistrationController;
import model.dao.impl.CarDaoJDBC;
import db.DB;
import model.Car;
import model.Concessionaire;
import model.services.CarService;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRegistrationView extends RegistrationView {



    public CarRegistrationView() {
    }

    public void carRegistrationView() {
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        boolean validInput = false;
        while (!validInput) {
            try {
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
                CarService carService = new CarService();
                carService.save(car);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}
