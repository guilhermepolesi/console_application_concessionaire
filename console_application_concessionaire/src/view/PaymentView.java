package view;

import controller.PaymentController;
import model.TypePayment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PaymentView {
    PaymentController paymentController = new PaymentController();

    public void formPayment(Double price) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Choose the form of payment:\n1 - CASH | 2 - PIX | 3 - CREDIT | 4 - DEBIT ");
        int value = sc.nextInt();
        if (value == 1 || value == 2) {
            TypePayment typePayment = TypePayment.fromInt(value);
            double payment = paymentController.paymentDown(price, typePayment);
            System.out.println("Payment of " + df.format(payment));
        }
        else if (value == 3) {
            System.out.print("How many installments? ");
            byte installments = sc.nextByte();
            paymentController.generateInstallments(price, installments);
            System.out.println(paymentController.installmentsToPay());
        }
        else {
            System.out.println("Payment of " + df.format(price));
        }
    }
}
