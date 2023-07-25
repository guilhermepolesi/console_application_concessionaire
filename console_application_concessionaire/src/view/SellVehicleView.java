package view;

import model.Concessionaire;
import model.Vehicle;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SellVehicleView {

    public SellVehicleView() {
    }

    public static void sellVehicleView(Concessionaire concessionaire) {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                PaymentView paymentView = new PaymentView();
                int confirmation = 0;
                double price = 0;
                DecimalFormat df = new DecimalFormat("#,###.00");
                while (confirmation != 1) {
                    System.out.print("Select a vehicle: ");
                    String model = sc.nextLine();
                    for (Vehicle vehicle : concessionaire.getList()) {
                        if (vehicle.getModel().equals(model)) {
                            System.out.println("Vehicle price: " + df.format(vehicle.getPrice()));
                            price = vehicle.getPrice();
                            System.out.print("If the model and value are correct type 1, if it is wrong type 2: \n");
                            confirmation = sc.nextInt();
                            sc.nextLine();
                        }
                    }
                }
                    paymentView.formPayment(price);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }
    }
}

