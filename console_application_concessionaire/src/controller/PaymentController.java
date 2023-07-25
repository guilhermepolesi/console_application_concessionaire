package controller;

import model.Installments;
import model.TypePayment;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentController {

    List<Installments> installmentsList = new ArrayList<>();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public List<Installments> getInstallmentsList() {
        return installmentsList;
    }
    private Double paymentDiscount(Double amountPaid, TypePayment typePayment) {
        if (typePayment.equals(TypePayment.CASH)) {
            double discount = amountPaid * 10.00 / 100.00;
            return amountPaid - discount;
        }
        else if (typePayment.equals(TypePayment.PIX)){
            double discount = amountPaid * 8.00 / 100.00;
            return amountPaid - discount;
        }
        return amountPaid;
    }
    public Double paymentDown(Double amount, TypePayment typePayment) {
        double payment = paymentDiscount(amount, typePayment);
        return payment;
    }

    public void generateInstallments(Double amount, Byte installments) {
        installmentsList.clear();
        double installmentsValue = amount / installments;
        LocalDate currentDate = LocalDate.now();
        for (int i = 1; i <= installments; i++) {
            LocalDate installmentDate = currentDate.plusMonths(i);
            Installments installments1 = new Installments(installmentsValue, i, installmentDate);
            installmentsList.add(installments1);
        }
    }

    public String installmentsToPay() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###.00");
        for (Installments installments : installmentsList) {
            String formattedAmount = df.format(installments.getAmount());
            String formattedDate = installments.getInstalmentDate().format(dateTimeFormatter);
            sb.append("Installment: " + installments.getInstallment() + "\nAmount: " + formattedAmount + "\nInstallment date: " + formattedDate + "\n----------------------------\n");
        }
        return sb.toString();
    }

}
