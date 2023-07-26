package view;


import controller.CarDaoJDBC;
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

    public void carRegistrationView(Concessionaire concessionaire) {
        boolean validInput = false;
        while (!validInput) {
            try {
                conn = DB.getConnection();
                Scanner sc = new Scanner(System.in);
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
                concessionaire.getList().add(car);
                concessionaire.getCarList().add(car);
                CarDaoJDBC carDaoJDBC = new CarDaoJDBC(conn);
                carDaoJDBC.insert(car);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}
