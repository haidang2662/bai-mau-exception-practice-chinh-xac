package entity;

import statics.CustomerType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Inputable {

    private static int AUTO_ID = 10000;
    private int id;
    private String name;
    private String address;
    private String phone;
    private CustomerType type;

    public Customer() {
        this.id = AUTO_ID++;
    }

    @Override
    public String toString() {
        return "entity.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type.value +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    @Override
    public void inputInfo() {
        System.out.print("Nhập tên: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chi: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập SDT: ");
        this.setPhone(new Scanner(System.in).nextLine());
        while (true) {
            String tempPhone = new Scanner(System.in).nextLine();
            if (tempPhone.matches("[^0d\\{9}]")) {
                this.setPhone(new Scanner(System.in).nextLine());
                break;
            }
            System.out.print("Số điện thoại không đúng định dạng, vui lòng nhập lại: ");
        }
        inputCustomerType();
    }

    private void inputCustomerType() {

        System.out.println("Chon loại khách hàng: ");
        System.out.println("1. Khách hàng cá nhân");
        System.out.println("2. Khách hàng nhóm");
        System.out.println("3. Khách hàng doanh nghiệp");
        System.out.println("Xin mời chon: ");

        int customerType;
        while (true) {
            try {
                customerType = new Scanner(System.in).nextInt();
                if (customerType <= 0 || customerType > 3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Loại khách hàng là một số nguyên dương trong đoạn từ 1 tới 3, vui lòng nhập lại: ");
            }
        }

        switch (customerType) {
            case 1:
                this.setType(CustomerType.PERSONAL);
                break;
            case 2:
                this.setType(CustomerType.GROUP);
                break;
            case 3:
                this.setType(CustomerType.ENTERPRISE);
                break;
        }
    }

}
