package PRO192x_ASM_thanhldFX20693.ASM2;

import PRO192x_ASM_thanhldFX20693.ASM2.controllers.CustomerController;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.views.Home;
import PRO192x_ASM_thanhldFX20693.Common;

public class Asm02 {
    private static final Bank bank = new Bank();
    private static final Home home = new Home();

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        home.showMainMenu();
        int selectedFunction = home.selectFunction();
        if (selectedFunction == 0){
            System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ của Ngân Hàng!");
            return;
        }
        CustomerController customerController = new CustomerController(bank);
        switch (selectedFunction) {
            case 1:
                customerController.addCustomer();
                break;
            case 2:
                customerController.addAccount();
                break;
            case 3:
                customerController.displayAll();
                break;
            case 4:
                customerController.searchById();
                break;
            case 5:
                customerController.searchByName();
                break;
            default:
                System.out.println("Chức năng chưa có sẵn, vui lòng chọn chức năng khác");
        }
        Common.continueOrEnd();
    }

}
