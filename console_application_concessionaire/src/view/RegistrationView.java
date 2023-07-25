package view;

import model.Concessionaire;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationView {

    public RegistrationView() {
    }


    public static void registrationView(Concessionaire concessionaire) {
        CarRegistrationView carRegistration = new CarRegistrationView();
        MotorcycleRegistrationView motorcycleRegistration = new MotorcycleRegistrationView();
        boolean validInput = false;
        while (!validInput) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("To register a car type 1.\nTo register a motorcycle type 2.");
                int register = sc.nextInt();
                if (register == 1) {
                    carRegistration.carRegistrationView(concessionaire);
                } else if (register == 2) {
                    motorcycleRegistration.motorcycleRegistrationView(concessionaire);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter number 1 or 2: ");
            }
            validInput = true;
        }
    }
}
