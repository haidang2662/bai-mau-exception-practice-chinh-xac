package service;

import entity.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public void showCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        // customers.forEach(System.out::println);
    }

    public void inputCustomers() {
        System.out.print("Bạn mới thêm mới bao khách hàng: ");
        int customerNumber;
        while (true) {
            try {
                customerNumber = new Scanner(System.in).nextInt();
                if (customerNumber <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Số lượng khách hàng là một số nguyên dương, vui lòng nhập lại: ");
            }
        }
        for (int i = 0; i < customerNumber; i++) {
            System.out.println("Nhập thông tin cho khách hàng thứ " + (i + 1));
            Customer customer = new Customer();
            customer.inputInfo();
            customers.add(customer);
        }
    }

    public Customer findById(int customerId) {
        for (int j = 0; j < customers.size(); j++) {
            if (customers.get(j).getId() == customerId) {
                return customers.get(j);
            }
        }
        return null;
    }

}
