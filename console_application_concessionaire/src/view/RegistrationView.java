package view;

import controller.RegistrationController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationView {

    public RegistrationView() {
    }

    public static void registrationView() {
        RegistrationController registrationController = new RegistrationController();
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("To register a car type 1.\nTo register a motorcycle type 2.");
                int register = sc.nextInt();
                registrationController.recordView(register);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter number 1 or 2: ");
            }
            validInput = true;
        }
    }
}
