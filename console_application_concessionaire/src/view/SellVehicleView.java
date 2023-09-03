package view;

import model.Car;
import model.Concessionaire;
import model.Vehicle;
import model.services.CarService;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SellVehicleView {

    public SellVehicleView() {
    }

    public static void sellVehicleView(Concessionaire concessionaire, Scanner sc) {
        CarService carService = new CarService();
        boolean validInput = false;
        while (!validInput) {
            Long id = null;
            try {
                PaymentView paymentView = new PaymentView();
                int confirmation = 0;
                double price = 0;
                DecimalFormat df = new DecimalFormat("#,###.00");
                while (confirmation != 1) {
                    System.out.print("Select a vehicle by id: ");
                    id = sc.nextLong();
                    Car car = carService.findById(id);
                            System.out.println("Vehicle price: " + df.format(car.getPrice()));
                            price = car.getPrice();
                            System.out.print("If the model and value are correct type 1, if it is wrong type 2: \n");
                            confirmation = sc.nextInt();
                            sc.nextLine();
                        }
                paymentView.formPayment(price);
                carService.remove(id);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}

