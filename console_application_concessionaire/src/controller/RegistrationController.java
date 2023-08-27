package controller;

import model.Concessionaire;
import view.CarRegistrationView;
import view.MotorcycleRegistrationView;

import java.util.Scanner;

public class RegistrationController {

    Scanner sc = new Scanner(System.in);

    public void recordView(Integer register) {
    CarRegistrationView carRegistration = new CarRegistrationView();
    MotorcycleRegistrationView motorcycleRegistration = new MotorcycleRegistrationView();
    if (register == 1) {
        carRegistration.carRegistrationView(sc);
    } else if (register == 2) {
        motorcycleRegistration.motorcycleRegistrationView(sc);
    }
}

}
