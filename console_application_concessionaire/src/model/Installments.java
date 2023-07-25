package model;

import java.time.LocalDate;

public class Installments {

    private Double amount;

    private Integer installment;

    private LocalDate instalmentDate;

    public Installments() {
    }

    public Installments(Double amount, Integer installment, LocalDate instalmentDate) {
        this.amount = amount;
        this.installment = installment;
        this.instalmentDate = instalmentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installments) {
        this.installment = installments;
    }


    public LocalDate getInstalmentDate() {
        return instalmentDate;
    }

    public void setInstalmentDate(LocalDate instalmentDate) {
        this.instalmentDate = instalmentDate;
    }
}
