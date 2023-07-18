package PRO192x_ASM_thanhldFX20693.ASM3.models;

import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Customer;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.List;

public class DigitalCustomer extends Customer {
    public void addAccount(SavingAccount newAccount) {
        super.addAccount(newAccount);
    }

    public void addAccount(LoanAccount newAccount) {
        super.addAccount(newAccount);
    }
}
