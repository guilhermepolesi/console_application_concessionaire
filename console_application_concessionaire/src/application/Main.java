package application;


import model.Car;
import model.Concessionaire;
import view.HomeView;
import view.RegistrationView;
import view.SellVehicleView;
import view.VehicleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaire concessionaire = new Concessionaire();
        Car car = new Car("CC", 2525, "k", 25252.0, 4);
        concessionaire.getCarList().add(car);
        concessionaire.getList().add(car);
        System.out.println("Program started");
        boolean started = true;
        while (started) {
            int choice = HomeView.printHomeView(sc);
            switch (choice) {
                case 1:
                    RegistrationView.registrationView(sc);
                    break;
                case 2:
                    VehicleView.showList(concessionaire, sc);
                    break;
                case 3:
                    SellVehicleView.sellVehicleView(concessionaire, sc);
                    break;
                case 4:
                    started = HomeView.turnOff();
                    break;
            }
        }
        sc.close();
    }
}