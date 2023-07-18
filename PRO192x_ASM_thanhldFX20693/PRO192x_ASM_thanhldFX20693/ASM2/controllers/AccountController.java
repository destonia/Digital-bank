package PRO192x_ASM_thanhldFX20693.ASM2.controllers;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.services.Validate;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.Objects;
import java.util.Scanner;

public class AccountController {
    public Bank bank;

    public AccountController(Bank bank) {
        this.bank = bank;
    }


    /*Nhập và kiểm tra mã STK*/
    public Account createAccount() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập mã STK bao gồm 6 chữ số: ");
            String stk = sc.next();
            if (Objects.equals(stk, "No")) {
                Asm02.startApp();
            } else {
                if (Validate.validateAccountNumber(stk)) {
                    if (!bank.isAccountExisted(stk)) {
                        return new Account(stk);
                    }
                    System.out.println("Số tài khoản này đã tồn tại,");
                    System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
                }
            }
        } while (true);
    }

    public void setBalance(Account account) {
        boolean flag = true;
        do {
            System.out.println("Nhập số dư");
            Scanner sc = new Scanner(System.in);
            try {
                String balance = sc.next();
                Validate validate = new Validate();
                if (Common.isNumeric(balance)) {
                    if (validate.validateBalanceNumber(Double.parseDouble(balance))) {
                        account.setBalance(Double.parseDouble(balance));
                        flag = false;
                    } else {
                        System.out.println("Vui lòng nhập số dư từ 50.000VNĐ trở lên");
                    }
                }else {
                    System.out.println("Sai định dạng, vui lòng thử lại");
                }

            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi hoặc nhập sai định dạng, vui lòng thử lại!");
            }
        } while (flag);
    }

}
