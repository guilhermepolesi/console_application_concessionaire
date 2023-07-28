package view;

import model.Concessionaire;
import model.Motorcycle;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MotorcycleRegistrationView {

    public MotorcycleRegistrationView() {
    }

    public void motorcycleRegistrationView(Scanner sc) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Motorcycle registration");
                System.out.print("Motorcycle model: ");
                String model = sc.nextLine();
                System.out.print("Motorcycle year: ");
                int year = sc.nextInt();
                System.out.print("Motorcycle manufacturer: ");
                sc.nextLine();
                String manufacturer = sc.nextLine();
                System.out.print("Motorcycle price: ");
                double price = sc.nextDouble();
                System.out.print("Motorcycle Engine Capacity: ");
                int engineCapacity = sc.nextShort();
                Motorcycle motorcycle = new Motorcycle(model, year, manufacturer, price, engineCapacity);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }

    }
}
