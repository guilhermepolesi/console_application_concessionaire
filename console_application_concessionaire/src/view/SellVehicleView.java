package view;

import model.Car;
import model.Motorcycle;
import model.services.CarService;
import model.services.MotorcycleService;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import java.util.Scanner;

public class SellVehicleView {

    public SellVehicleView() {
    }

    public static void sellVehicleView() {
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        CarService carService = new CarService();
        Motorcycle motorcycle = new Motorcycle();
        MotorcycleService motorcycleService = new MotorcycleService();
        boolean validInput = false;
        while (!validInput) {
            Long id = null;
            try {
                PaymentView paymentView = new PaymentView();
                int choice = 0;
                int confirmation = 0;
                double price = 0;
                DecimalFormat df = new DecimalFormat("#,###.00");
                while (confirmation != 1) {
                    System.out.println("1 - Sell car | 2 - Sell motorcycle: ");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        while (confirmation != 1) {
                            System.out.print("Select a vehicle by id: ");
                            id = sc.nextLong();
                            car = carService.findById(id);
                            System.out.println("Vehicle price: " + df.format(car.getPrice()));
                            price = car.getPrice();
                            System.out.print("If the model and value are correct type 1, if it is wrong type 2: \n");
                            confirmation = sc.nextInt();
                        }
                        paymentView.formPayment(price);
                        carService.remove(id);
                    }
                    else {
                        while (confirmation != 1) {
                            System.out.print("Select a vehicle by id: ");
                            id = sc.nextLong();
                            motorcycle = motorcycleService.findById(id);
                            System.out.println("Vehicle price: " + df.format(motorcycle.getPrice()));
                            price = motorcycle.getPrice();
                            System.out.print("If the model and value are correct type 1, if it is wrong type 2: \n");
                            confirmation = sc.nextInt();
                        }
                        paymentView.formPayment(price);
                        motorcycleService.remove(id);
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}

