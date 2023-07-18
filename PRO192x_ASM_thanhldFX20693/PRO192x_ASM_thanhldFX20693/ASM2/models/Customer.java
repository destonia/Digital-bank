package PRO192x_ASM_thanhldFX20693.ASM2.models;

import PRO192x_ASM_thanhldFX20693.Common;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts = new ArrayList<Account>();

    public Customer() {

    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        for (Account account : accounts) {
            if (account.isPremium()) {
                return true;
            }
        }
        return false;
    }

    public double getBalance() {
        double result = 0;
        for (Account account : accounts) {
            result += account.getBalance();
        }
        return result;
    }

    public void addAccount(Account newAccount) {
        if (!isAccountExisted(newAccount.getAccountNumber())) {
            accounts.add(newAccount);
        }
    }

    public void displayInfo() {
        Common common = new Common();
        int RESERVED_SPACE = 20;
        String BORDER = "  |";
        String isPremium = isPremium() ? "   Premimum" : "     Normal";
        System.out.println(
                getCustomerId() +
                        BORDER +
                        common.toFixedLength(RESERVED_SPACE, getName()) +
                        BORDER +
                        isPremium +
                        BORDER +
                        common.toFixedLength(RESERVED_SPACE, common.formatCurrency(getBalance()))

        );
        int i = 1;
        for (Account account : accounts) {
            System.out.println(
                    "   " + i + "   " + account.toString());
            i++;
        }

    }

    public boolean isAccountExisted(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public Account getAccountById(String accountNumber){
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
