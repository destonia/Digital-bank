package PRO192x_ASM_thanhldFX20693.ASM3.models;

import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.Collections;
import java.util.Date;

public class LoanAccount extends Account {
    private double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    private String accountType = "LOAN";
    public LoanAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public String toString() {
        String strBalance = Common.formatCurrency(this.getBalance());
        return this.getAccountNumber() + " |" + String.join("", Collections.nCopies(16, " ")) + "LOAN  |" + String.join("", Collections.nCopies(34 - strBalance.length(), " ")) + strBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        return isAccepted(amount);
    }

    @Override
    public boolean isAccepted(double amount) {
        double balance = getBalance();
        return !(amount > LOAN_ACCOUNT_MAX_BALANCE) && !(balance - amount < 50000);
    }

    @Override
    public double getTransactionFee(){
        if (isPremium()){
            return LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
        }
        return LOAN_ACCOUNT_WITHDRAW_FEE;
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
