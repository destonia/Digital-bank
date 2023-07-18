package PRO192x_ASM_thanhldFX20693.ASM3.controllers;

import PRO192x_ASM_thanhldFX20693.ASM2.controllers.CustomerController;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM3.models.DigitalBank;

public class DigitalCustomerController extends CustomerController {
    public DigitalCustomerController(DigitalBank activeBank) {
        super(activeBank);
    }
}
