package PRO192x_ASM_thanhldFX20693.ASM1;

import PRO192x_ASM_thanhldFX20693.ASM2.controllers.CustomerController;
import PRO192x_ASM_thanhldFX20693.ASM2.models.Bank;
import PRO192x_ASM_thanhldFX20693.ASM2.services.CustomerService;
import PRO192x_ASM_thanhldFX20693.MenuItem;

import java.util.Collections;
import java.util.Scanner;

public class Home {
    private final String BANK_NAME = "| NGAN HANG SO ";
    private final String AUTHOR = "| FX20693";
    private final String VERSION = "@v1.0.0";

    private int mode;

    public Home() {
        Mode mode = new Mode();
        mode.displayMenu();
        mode.selectMode();
        int selectedMode = mode.getSelectedMode();
        this.mode = selectedMode;
        if (selectedMode == 0) {
            System.out.println("Ban da chon che do: EASY");
        } else {
            System.out.println("Ban da chon che do: HARD");
        }
    }

    private final MenuItem[] MENU_ITEMS = {
            new MenuItem("Nhap CCCD", 1),
            new MenuItem("Thoat", 0)};
    private final int HUMAN_VERIFY_TIME = 3;

    public String generateRandomString(int length) {
        String result = "";
        String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstvuwxyz0123456789";
        for (int i = 0; i < length; i++) {
            result = result + range.charAt((int) (Math.random() * range.length()));
        }
        return result;
    }

    public String generateVerifyCode(int mode) {
        if (mode == 0) {
            return String.valueOf((int) (Math.random() * (999 - 100) + 100));
        }
        if (mode == 1) {
            return generateRandomString(6);
        }
        return null;
    }

    public void displayHome() {
        String VERTICAL_LINE = "+" +
                String.join("", Collections.nCopies(10, "-")) +
                "+" + String.join("", Collections.nCopies(20, "-")) + "+" +
                String.join("", Collections.nCopies(10, "-")) + "+";
        String LEFT_BORDER = "| ";
        String RIGHT_BORDER = " |";
        String content = BANK_NAME + AUTHOR + VERSION;
        String blankSpace = String.join("", Collections.nCopies(VERTICAL_LINE.length() - content.length() - 2, " "));
        System.out.println(VERTICAL_LINE);
        System.out.print(content + blankSpace);
        System.out.println(RIGHT_BORDER);
        System.out.println(VERTICAL_LINE);
        for (MenuItem menuItem : MENU_ITEMS) {
            content = LEFT_BORDER + menuItem.getNumber() + ". " + menuItem.getName();
            blankSpace = String.join("", Collections.nCopies(VERTICAL_LINE.length() - content.length() - 2, " "));
            System.out.print(content + blankSpace);
            System.out.println(RIGHT_BORDER);
        }
        System.out.println(VERTICAL_LINE);
    }

    public boolean verifyHuman(int limit, String verifyCode) {
        System.out.print("Nhap ma xac thuc: ");
        System.out.println(verifyCode);
        Scanner sc = new Scanner(System.in);
        String typeinCode = sc.next();
        if (typeinCode.equals(verifyCode)) {
            return true;
        } else {
            limit = limit - 1;
            if (limit > 0) {
                System.out.println("Ma xac thuc khong dung. Vui long nhap lai, so lan con lai: " + limit);
                verifyHuman(limit, verifyCode);
            } else {
                System.out.println("Ban da nhap sai qua so lan cho phep!!!");
                return false;
            }
        }
        return false;
    }

    public void checkCCCD() {
        String verifyCode = generateVerifyCode(mode);
        if (verifyHuman(HUMAN_VERIFY_TIME, verifyCode)) {
            CustomerService customerService = new CustomerService(new Bank());
            String cccdNumber = customerService.createCustomerId();
            if (cccdNumber.equals("No")) {
                startApp();
            } else {
                CCCD cccd = new CCCD(cccdNumber);
                cccd.startCheckCCCD(this);
            }
        } else {
            startApp();
        }
    }

    public void selectFunction() {
        System.out.print("Chuc nang: ");
        try {
            Scanner sc = new Scanner(System.in);
            int selectedfunction = sc.nextInt();
            switch (selectedfunction) {
                case 1:
                    checkCCCD();
                    break;
                case 0:
                    System.out.println("Tam biet");
                    break;
                default:
                    System.out.println("!!! Chuc nang chua co san, vui long chon lai");
                    startApp();
            }
        } catch (Exception e) {
            System.out.println("!!! Da xay ra loi hoac ban da chon chuc nang chua co san, Vui long chon lai chuc nang");
            startApp();
        }
    }

    public void startApp() {
        displayHome();
        selectFunction();
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.startApp();
    }

}
