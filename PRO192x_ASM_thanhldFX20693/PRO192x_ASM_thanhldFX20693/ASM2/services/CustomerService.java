package PRO192x_ASM_thanhldFX20693.ASM2.services;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private Bank bank;

    public CustomerService(Bank bank) {
        this.bank = bank;
    }

    public String createCustomerName() {
        try {
            System.out.print("Nhập tên khách hàng: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        } catch (Exception e) {
            createCustomerName();
            return null;
        }
    }

    /* Nhập số CCCD khách hàng */
    public String createCustomerId() {
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        try {
            /* Kiểm tra số CCCD nhập vào là hợp lệ, nếu không thì yêu cầu nhập lại */
            do {
                System.out.print("Nhập số CCCD khách hàng: ");
                String cccdNumber = sc.next();
                if (cccdNumber.equals("No")) {
                    Asm02.startApp();
                } else {
                    if (validate.validateCccd(cccdNumber)) {
                        return cccdNumber;
                    } else {
                        System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ,");
                    }
                }
            }
            while (true);
        } catch (Exception e) {
            return null;
        }
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : bank.getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomerByName(String customerName) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : bank.getCustomers()) {
            if (customer.getName().toUpperCase().contains(customerName)) {
                customers.add(customer);
            }
        }
        return customers;
    }
}
