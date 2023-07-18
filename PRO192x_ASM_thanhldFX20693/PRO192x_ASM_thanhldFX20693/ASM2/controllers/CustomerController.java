package PRO192x_ASM_thanhldFX20693.ASM2.controllers;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Customer;
import PRO192x_ASM_thanhldFX20693.ASM2.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private Bank bank;
    private CustomerService customerService;

    public CustomerController(Bank bank) {
        this.bank = bank;
        this.customerService = new CustomerService(bank);
    }

    /* Add new Customer*/
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName(customerService.createCustomerName());
        String cccdNumber;
        boolean flag = true;
        do {
            cccdNumber = customerService.createCustomerId();
            if (bank.isCustomerExisted(cccdNumber)) {
                System.out.println("Số CCCD này đã tồn tại trong hệ thống,");
                System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
            } else {
                flag = false;
            }
        } while (flag);

        customer.setCustomerId(cccdNumber);
        bank.addCustomer(customer);
    }

    /* Add new Account */
    public void addAccount() {
        String customerId;
        try {
            customerId = customerService.createCustomerId();
            AccountController accountController = new AccountController(bank);
            Account account = accountController.createAccount();
            accountController.setBalance(account);
            bank.addAccount(customerId, account);
            System.out.println("Thêm mới tài khoản thành công!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi thêm mới tài khoản, vui lòng thử lại!");
        }
    }

    public void displayAll() {
        if (bank.getCustomers().isEmpty()) {
            System.out.println("Ngân hàng " + bank.getId() + " Chưa có khách hàng!");
        } else {
            for (Customer customer : bank.getCustomers()) {
                customer.displayInfo();
            }
        }
    }

    public void searchById() {
        String customerId = customerService.createCustomerId();
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            customer.displayInfo();
        } else {
            System.out.println("Không tìm thấy khách hàng có ID: " + customerId);
        }
    }

    public void searchByName() {
        String customerName = customerService.createCustomerName().toUpperCase();
        List<Customer> customers = customerService.getCustomerByName(customerName);
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                customer.displayInfo();
            }
        } else {
            System.out.println("Không tìm thấy khách hàng có tên: " + customerName);
        }
    }
}
