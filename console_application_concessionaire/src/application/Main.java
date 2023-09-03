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
        System.out.println("Program started");
        boolean started = true;
        while (started) {
            int choice = HomeView.printHomeView(sc);
            switch (choice) {
                case 1:
                    RegistrationView.registrationView();
                    break;
                case 2:
                    VehicleView.showList(concessionaire);
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