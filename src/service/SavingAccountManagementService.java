package service;

import entity.Bank;
import entity.Customer;
import entity.SavingAccount;
import entity.SavingAccountManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavingAccountManagementService {

    private CustomerService customerService;
    private BankService bankService;

    private final List<SavingAccountManagement> savingAccountManagements = new ArrayList<>();

    public SavingAccountManagementService(CustomerService customerService, BankService bankService) {
        this.customerService = customerService;
        this.bankService = bankService;
    }

    public void showSavingAccountManagements() {
        savingAccountManagements.forEach(System.out::println);
    }

    public void createSavingAccountManagement() {
        // check xem có ngân hàng và khách hàng trong hệ thống hay cuwua, nếu có thì mới cho đi tao
        System.out.println("Có bao nhiêu khách hàng muốn gửi sổ tiết kiệm: ");
        int customerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < customerNumber; i++) {
            System.out.println("Nhập thông tin gửi tiết kiệm cho khách hàng thứ " + (i + 1));
            Customer customer = inputCustomer();

            List<SavingAccount> savingAccounts = createSavingAccount();
            savingAccountManagements.add(new SavingAccountManagement(customer, savingAccounts));
        }
    }

    private Customer inputCustomer() {
        System.out.println("Nhập mã khách hang: ");
        int customerId;
        Customer customer = null;
        while (true) {
            customerId = new Scanner(System.in).nextInt();
            customer = customerService.findById(customerId);
            if (customer != null) {
                break;
            }
            System.out.print("Taif khoản không tồn tại, vui lòng nhập lại: ");
        }
        return customer;
    }

    private List<SavingAccount> createSavingAccount() {
        System.out.println("Nhập số lượng ngân hàng muốn gửi tiết kiệm: ");
        int bankNumber = new Scanner(System.in).nextInt();
        List<SavingAccount> savingAccounts = new ArrayList<>();
        for (int j = 0; j < bankNumber; j++) {
            System.out.println("Nhập thông tin cho sổ tiết kiệm thứ " + (j + 1));
            System.out.println("Nhập mã ngân hàng muốn gửi sổ: ");
            int bankId;
            Bank bank;
            while (true) {
                bankId = new Scanner(System.in).nextInt();
                bank = bankService.findById(bankId);
                if (bank != null) {
                    break;
                }
                System.out.print("Ngan hàng không tồn tại, vui lòng nhập lại: ");
            }

            // kiểm tra xem so lưượng sổ tiết kiệm của ông khách hàng đang nhập có vượt quá 5 hay không

            System.out.println("Nhập số tiền muốn gui ở ngân hàng này: ");
            double money = new Scanner(System.in).nextDouble();
            SavingAccount savingAccount = new SavingAccount(bank, money);
            savingAccounts.add(savingAccount);
        }
        return savingAccounts;
    }

}
