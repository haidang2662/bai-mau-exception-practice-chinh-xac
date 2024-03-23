package entity;

import java.time.LocalDate;

public class SavingAccount {

    private Bank bank;

    private double amount;

    private LocalDate createdDate;

    public SavingAccount(Bank bank, double amount) {
        this.bank = bank;
        this.amount = amount;
        this.createdDate = LocalDate.now();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
