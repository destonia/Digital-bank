package PRO192x_ASM_thanhldFX20693.ASM2.models;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;
import PRO192x_ASM_thanhldFX20693.ASM2.controllers.CustomerController;
import PRO192x_ASM_thanhldFX20693.ASM3.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers = new ArrayList<Customer>();
    public String MESSAGE_CUSTOMER_EXSITED = "Khách hàng đã tồn tại trong hệ thống";
    public Bank(){
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }
    public void addCustomer(Customer newCustomer){
        try {
            customers.add(newCustomer);
            System.out.println("Đã thêm khách hàng "+newCustomer.getCustomerId()+" vào danh sách");
        }catch (Exception e){
            System.out.println("Da co loi xay ra khi them moi 1 khach hang!");
        }
    }
    public void addAccount(String customerId, Account account){
        if (isCustomerExisted(customerId)){
            for (Customer customer: customers){
                if (customer.getCustomerId().equals(customerId)){
                    customer.addAccount(account);
                    Transaction transaction = new Transaction(account.getBalance(),true);
                    account.addTransaction(transaction);
                }
            }
        }
        else {
            System.out.println("Khách hàng " + customerId + " Không có trong hệ thống,");
        }
    }
    public boolean isCustomerExisted(String customerId){
        for (Customer customer: customers){
            if (customer.getCustomerId().equals(customerId)){
                return true;
            }
        }
        return false;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    public boolean isAccountExisted(String accountNumber){
        for (Customer customer: customers){
            if (customer.isAccountExisted(accountNumber)){
                return true;
            }
        }
        return false;
    }
}
