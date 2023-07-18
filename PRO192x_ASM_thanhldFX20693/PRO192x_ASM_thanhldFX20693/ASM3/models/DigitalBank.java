package PRO192x_ASM_thanhldFX20693.ASM3.models;

import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Customer;
import PRO192x_ASM_thanhldFX20693.ASM3.ASM3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DigitalBank extends Bank {
    public void addCustomer(String CUSTOMER_ID, String CUSTOMER_NAME) {
        DigitalCustomer customer = new DigitalCustomer();
        customer.setCustomerId(CUSTOMER_ID);
        customer.setName(CUSTOMER_NAME);
        super.addCustomer(customer);
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        System.out.println("Không tìm thấy khách hàng có mã: " + customerId);
        return null;
    }

    public boolean withdraw(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomerById(customerId);
        Account account = customer.getAccountById(accountNumber);
        if (account.withdraw(amount)) {
            System.out.println("Rút tiền thành công!");
            account.setBalance(account.getBalance() - amount - account.getTransactionFee() * amount);
            Transaction transaction = new Transaction(amount*-1,true);
            account.addTransaction(transaction);
            account.log(amount);
            return true;
        } else {
            System.out.println("Rút tiền không thành công");
            Transaction transaction = new Transaction(amount,false);
            account.addTransaction(transaction);
            return false;
        }
    }
}
