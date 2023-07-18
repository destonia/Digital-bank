package PRO192x_ASM_thanhldFX20693.ASM2.models;

import PRO192x_ASM_thanhldFX20693.ASM3.interfaces.ReportService;
import PRO192x_ASM_thanhldFX20693.ASM3.interfaces.Withdraw;
import PRO192x_ASM_thanhldFX20693.ASM3.models.Transaction;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements Withdraw, ReportService {
    private String accountNumber;
    private String accountType;
    private List<Transaction> transactions = new ArrayList<>();

    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isPremium() {
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    public String toString() {
        Common common = new Common();
        String strBalance = common.formatCurrency(balance);
        return accountNumber + " |" + String.join("", Collections.nCopies(57 - strBalance.length(), " ")) + strBalance;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        return false;
    }

    public double getTransactionFee(){
        return 0;
    }

    @Override
    public void log(double amount) {

    }
}
