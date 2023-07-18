package PRO192x_ASM_thanhldFX20693.ASM3.controllers;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;
import PRO192x_ASM_thanhldFX20693.ASM2.controllers.AccountController;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.services.Validate;
import PRO192x_ASM_thanhldFX20693.ASM3.ASM3;
import PRO192x_ASM_thanhldFX20693.ASM3.interfaces.Withdraw;
import PRO192x_ASM_thanhldFX20693.ASM3.models.DigitalBank;
import PRO192x_ASM_thanhldFX20693.ASM3.models.LoanAccount;

import java.util.Objects;
import java.util.Scanner;

public class LoanAccountController extends AccountController {
    public LoanAccountController(DigitalBank bank) {
        super(bank);
    }

    @Override
    public LoanAccount createAccount() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập mã STK bao gồm 6 chữ số: ");
            String stk = sc.next();
            if (stk.equalsIgnoreCase("No")) {
                ASM3.startApp();
            } else {
                if (Validate.validateAccountNumber(stk)) {
                    if (!bank.isAccountExisted(stk)) {
                        return new LoanAccount(stk);
                    }
                    System.out.println("Số tài khoản này đã tồn tại,");
                    System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
                }
            }
        } while (true);
    }


}
