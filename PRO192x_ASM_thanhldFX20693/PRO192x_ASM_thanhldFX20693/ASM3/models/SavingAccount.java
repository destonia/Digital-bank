package PRO192x_ASM_thanhldFX20693.ASM3.models;

import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.Collections;

public class SavingAccount extends Account {
    private double MAX_WITHDRAW = 5000000;
    private String accountType = "SAVINGS";
    public SavingAccount(String accountNumber) {
        super(accountNumber);
    }
    @Override
    public String toString() {
        String strBalance = Common.formatCurrency(this.getBalance());
        return this.getAccountNumber() + " |" + String.join("", Collections.nCopies(13, " ")) +  "SAVINGS  |" + String.join("", Collections.nCopies(34 - strBalance.length(), " ")) + strBalance;
    }

    public boolean withdraw(double amount) {
        return isAccepted(amount);
    }

    @Override
    public boolean isAccepted(double amount) {
        double balance = getBalance();
        return !(amount > MAX_WITHDRAW) && !(balance - amount < 50000);
    }

    @Override
    public void log(double amount) {
        String VERTICAL_LINE = "+" +
                String.join("", Collections.nCopies(10, "-")) +
                "+" + String.join("", Collections.nCopies(20, "-")) + "+" +
                String.join("", Collections.nCopies(10, "-")) + "+";
        System.out.println(VERTICAL_LINE);
        System.out.printf("%30s%n","BIEN LAI GIAO DICH " + accountType);
        System.out.printf("NGAY G/D: %28s%n", Common.getCurrentDateTime());
        System.out.printf("ATM ID: %30s%n","DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Common.formatCurrency(amount));
        System.out.printf("SO DU: %31s%n",Common.formatCurrency(getBalance()));
        System.out.printf("PHI + VAT: %27s%n",Common.formatCurrency(getTransactionFee() * amount));
        System.out.println(VERTICAL_LINE);
    }
}
