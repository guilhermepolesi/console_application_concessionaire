package view;

import model.Concessionaire;
import model.Motorcycle;
import model.services.MotorcycleService;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MotorcycleRegistrationView {

    public MotorcycleRegistrationView() {
    }

    public void motorcycleRegistrationView() {
        Scanner sc = new Scanner(System.in);
        Motorcycle motorcycle = new Motorcycle();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Motorcycle registration");
                System.out.print("Motorcycle model: ");
                motorcycle.setModel(sc.nextLine());
                System.out.print("Motorcycle year: ");
                motorcycle.setYear(sc.nextInt());
                System.out.print("Motorcycle manufacturer: ");
                sc.nextLine();
                motorcycle.setManufacturer(sc.nextLine());
                System.out.print("Motorcycle Engine Capacity: ");
                motorcycle.setEngineCapacity(sc.nextInt());
                System.out.print("Motorcycle price: ");
                motorcycle.setPrice(sc.nextDouble());
                MotorcycleService motorcycleService = new MotorcycleService();
                motorcycleService.save(motorcycle);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
            validInput = true;
        }

    }
}
