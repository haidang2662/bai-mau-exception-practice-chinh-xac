package entity;

import java.util.List;
import java.util.Map;

public class SavingAccountManagement {

    private Customer customer;

    private List<SavingAccount> savingAccounts;

    public SavingAccountManagement(Customer customer, List<SavingAccount> savingAccounts) {
        this.customer = customer;
        this.savingAccounts = savingAccounts;
    }
}
