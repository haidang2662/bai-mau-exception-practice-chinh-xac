package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank implements Inputable {

    private static int AUTO_ID = 100;
    private int id;
    private String name;
    private float interestRate;

    public Bank() {
        this.id = AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "entity.Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }


    public void inputInfo() {
        System.out.println("Nhập tên ngân hàng: ");
        name = new Scanner(System.in).nextLine();
        System.out.println("Nhập lãi suất: ");
        while (true) {
            try {
                float interestRate = new Scanner(System.in).nextFloat();
                if (interestRate <= 0) {
                    throw new InputMismatchException();
                }
                this.interestRate = interestRate;
                break;
            } catch (InputMismatchException e) {
                System.out.print("Lãi suất là số dương, vui lòng nhập lại: ");
            }
        }
    }
}
