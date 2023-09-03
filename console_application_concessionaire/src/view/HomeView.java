package view;

import db.DB;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeView {

    private Boolean started;


    public HomeView() {
    }

    public HomeView(Boolean started) {
        this.started = started;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public static Boolean turnOff() {
        DB.closeConnection();
        return false;
    }


    public static int printHomeView() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("1-Register vehicle\n2-Vehicle list\n" +
                        "3-Sell vehicle\n" + "4-Exit");
                choice = sc.nextInt();
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number from 1 to 4: ");
            }

        }
        return choice;
    }
}
