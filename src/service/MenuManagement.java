package service;

import util.IOUtil;

public class MenuManagement {
    private final CustomerService customerService = new CustomerService();
    private final BankService bankService = new BankService();
    private final SavingAccountManagementService savingAccountManagementService = new SavingAccountManagementService(customerService, bankService);

    public void menu() {
        while (true) {
            showMenuContent();
            int featureChoice = chooseFeature();
            switch (featureChoice) {
                case 1:
                    customerService.inputCustomers();
                    break;
                case 2:
                    customerService.showCustomers();
                    break;
                case 3:
                    bankService.inputBanks();
                    break;
                case 4:
                    bankService.showBanks();
                    break;
                case 5:
                    savingAccountManagementService.createSavingAccountManagement();
                    break;
                case 6:
                    savingAccountManagementService.showSavingAccountManagements();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }
    }

    private int chooseFeature() {
        System.out.print("Xin mời chọn chức năng: ");
        return IOUtil.inputNumber(1, 8, "Chức năng không hợp lệ, vui lòng nhập lại: ");
    }

    public void showMenuContent() {
        System.out.println("--------PHẦN MỀM QUẢN LÝ SỔ TIẾT KIỆM--------");
        System.out.println("1. Thêm mới khách hàng");
        System.out.println("2. Hiển thị danh sách khách hàng đang có");
        System.out.println("3. Thêm mới ngân hàng");
        System.out.println("4. Hiển thị danh sách ngân hàng");
        System.out.println("5. Lập sổ tiết kiệm");
        System.out.println("6. Hiển thị danh sách sổ tiết kiệm");
        System.out.println("7. Sắp xếp danh sách sổ tiết kiệm");
        System.out.println("8. Lập bảng thống kê tiền gửi");
        System.out.println("9. Thoát");
    }


}
