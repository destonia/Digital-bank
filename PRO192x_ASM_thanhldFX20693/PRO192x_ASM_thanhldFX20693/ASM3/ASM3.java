package PRO192x_ASM_thanhldFX20693.ASM3;

import PRO192x_ASM_thanhldFX20693.ASM2.models.Account;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Customer;
import PRO192x_ASM_thanhldFX20693.ASM2.services.Validate;
import PRO192x_ASM_thanhldFX20693.ASM3.controllers.LoanAccountController;
import PRO192x_ASM_thanhldFX20693.ASM3.controllers.SavingAccountController;
import PRO192x_ASM_thanhldFX20693.ASM3.models.DigitalBank;
import PRO192x_ASM_thanhldFX20693.ASM3.models.LoanAccount;
import PRO192x_ASM_thanhldFX20693.ASM3.models.SavingAccount;
import PRO192x_ASM_thanhldFX20693.ASM3.models.Transaction;
import PRO192x_ASM_thanhldFX20693.ASM3.views.Home;
import PRO192x_ASM_thanhldFX20693.Common;

import java.util.Scanner;

public class ASM3 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";

    public static void main(String[] args) {
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        startApp();
    }

    public static void startApp() {
        Home.showMainMenu();
        int selectedFunction = Home.selectFunction();
        if (selectedFunction == EXIT_COMMAND_CODE) {
            System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ của Ngân Hàng!");
            return;
        }
        switch (selectedFunction) {
            case 1:
                showCustomer();
                break;
            case 2:
                addSavingAccount();
                break;
            case 3:
                addLoanAccount();
                break;
            case 4:
                withdraw();
                break;
            case 5:
                showHistory();
                break;
            default:
                System.out.println("Chức năng chưa có sẵn, vui lòng chọn chức năng khác");
        }
        continueOrEnd();
    }

    public static void showCustomer() {
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInfo();
        }
    }

    public static void addSavingAccount() {
        try {
            SavingAccountController savingAccountController = new SavingAccountController(activeBank);
            SavingAccount account = savingAccountController.createAccount();
            savingAccountController.setBalance(account);
            activeBank.addAccount(CUSTOMER_ID, account);
            System.out.println("Thêm mới tài khoản ATM thành công!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi thêm mới tài khoản ATM, vui lòng thử lại!");
        }
    }

    public static void addLoanAccount() {
        try {
            LoanAccountController loanAccountController = new LoanAccountController(activeBank);
            LoanAccount account = loanAccountController.createAccount();
            loanAccountController.setBalance(account);
            activeBank.addAccount(CUSTOMER_ID, account);
            System.out.println("Thêm mới tài khoản Tín Dụng thành công!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi thêm mới tài khoản Tín Dụng, vui lòng thử lại!");
        }
    }

    public static void withdraw() {
        if (!activeBank.isCustomerExisted(CUSTOMER_ID)) {
            System.out.println("Không tìm thấy khách hàng có mã: " + CUSTOMER_ID);
            System.out.println("Vui lòng thử lại!");
            withdraw();
        }

        // get account number from keyboard
        String accountNumber = createAccountNumber();

        System.out.print("Vui lòng nhập số tiền cần rút: ");
        boolean flag = true;
        String amount;
        do {
            amount = scanner.next();
            if (amount.equalsIgnoreCase("NO")) {
                flag = false;
                ASM3.startApp();
            }
            if (Common.isNumeric(amount)) {
                try {
                    flag = !activeBank.withdraw(CUSTOMER_ID, accountNumber, Double.parseDouble(amount));
                    if (flag){
                        System.out.println("Vui lòng nhập lại số tiền cần rút:");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Số tài khoản không đúng hoặc sai định dạng,");
                System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
            }
        } while (flag);
    }

    public static String createAccountNumber(){
        System.out.print("Vui lòng nhập số tài khoản: ");
        boolean flag = true;
        String accountNumber;
        do {
            accountNumber = scanner.next();
            if (accountNumber.equalsIgnoreCase("NO")) {
                flag = false;
                ASM3.startApp();
            }
            if (Validate.validateAccountNumber(accountNumber)) {
                if (!activeBank.isAccountExisted(accountNumber)) {
                    System.out.println("Không tìm thấy tài khoản có mã: " + accountNumber);
                    System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
                } else {
                    flag = false;
                }
            } else {
                System.out.println("Số tài khoản không đúng hoặc sai định dạng,");
                System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát: ");
            }
        } while (flag);
        return accountNumber;
    }

    public static void showHistory(){
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInfo();
            for (Account account: customer.getAccounts()){
                String accountNumber = account.getAccountNumber();
                for (Transaction transaction: account.getTransactions()){
                    if (transaction.getStatus()){
                        System.out.print("   [GD]:");
                        System.out.print(accountNumber);
                        System.out.print("|      ");
                        System.out.print(Common.formatCurrency(transaction.getAmount()));
                        System.out.print("  |");
                        System.out.println(transaction.getTime());
                    }
                }
            }
        }

    }
    public static void continueOrEnd() {
        boolean flag = true;
        do {
            System.out.println("Vui lòng nhập 'Y' để tiếp tục, 'N' để thoát: ");
            Scanner sc = new Scanner(System.in);
            String isContinue = sc.next().toUpperCase();
            switch (isContinue) {
                case "Y":
                    flag = false;
                    ASM3.startApp();
                    break;
                case "N":
                    System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ của Ngân Hàng!");
                    flag = false;
                    break;
            }
        }
        while (flag);
    }
}
