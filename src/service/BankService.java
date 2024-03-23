package service;

import entity.Bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankService {

    private final List<Bank> banks = new ArrayList<>();


    public void showBanks() {
        banks.forEach(System.out::println);
    }

    public void inputBanks() {
        System.out.print("Bạn mới thêm mới bao nhiêu ngân hàng: ");
        int bankNumber;
        while (true) {
            try {
                bankNumber = new Scanner(System.in).nextInt();
                if (bankNumber <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Số lượng ngân hàng là số dương, vui lòng nhập lại: ");
            }
        }
        for (int i = 0; i < bankNumber; i++) {
            System.out.println("Nhập thông tin cho ngân hàng thứ " + (i + 1));
            Bank bank = new Bank();
            bank.inputInfo();
            banks.add(bank);
        }
    }

    public Bank findById(int bankId) {
        for (int k = 0; k < banks.size(); k++) {
            if (banks.get(k).getId() == bankId) {
                return banks.get(k);
            }
        }
        return null;
    }


}
