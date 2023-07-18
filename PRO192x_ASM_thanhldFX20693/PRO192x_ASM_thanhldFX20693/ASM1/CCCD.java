package PRO192x_ASM_thanhldFX20693.ASM1;

import PRO192x_ASM_thanhldFX20693.MenuItem;

import java.util.Collections;
import java.util.Scanner;

public class CCCD {
    private String cccd;
    private Home home;
    private final MenuItem[] MENU_ITEMS = {
            new MenuItem("Kiem tra noi sinh", 1),
            new MenuItem("Kiem tra tuoi, gioi tinh", 2),
            new MenuItem("Kiem tra ngau nhien", 3),
            new MenuItem("Thoat", 0)};

    private int mode;

    public CCCD(String cccd) {
        this.cccd = cccd;
    }

    public String getCccdNumber() {
        return cccd;
    }

    public void setCccdNumber(String cccd) {
        this.cccd = cccd;
    }

    public void displayMenu() {
        String indent = String.join("", Collections.nCopies(3, " "));
        String LEFT_BORDER = indent + "| ";
        for (MenuItem menuItem : MENU_ITEMS) {
            String content = LEFT_BORDER + menuItem.getNumber() + ". " + menuItem.getName();
            System.out.println(content);
        }
    }

    private void checkBirthPlace(String cccdNumber) {
        Prefecture prefecture = new Prefecture();
        String preNumber = cccdNumber.substring(0, 3);
        System.out.println("Noi Sinh: " + prefecture.getPrefecture(preNumber));
    }


    private void checkAgeGenre(String cccdNumber) {
        String ageGenreNumber = cccdNumber.substring(3, 6);
        AgeAndGenre ageAndGenre = new AgeAndGenre();
        System.out.println("Gioi Tinh: " + ageAndGenre.getAgeAndGenre(ageGenreNumber));
    }

    private void checkRandomNumber(String cccdNumber) {
        System.out.println("So Ngau Nhien: " + cccdNumber.substring(6));
    }

    public void selectFunction(String cccdNumber) {
        displayMenu();
        System.out.print("Chuc nang: ");
        try {
            Scanner sc = new Scanner(System.in);
            int selectedfunction = sc.nextInt();
            switch (selectedfunction) {
                case 1:
                    checkBirthPlace(cccdNumber);
                    selectFunction(cccdNumber);
                    break;
                case 2:
                    checkAgeGenre(cccdNumber);
                    selectFunction(cccdNumber);
                    break;
                case 3:
                    checkRandomNumber(cccdNumber);
                    selectFunction(cccdNumber);
                    break;
                case 0:
                    home.startApp();
                    break;
                default:
                    System.out.println("Chuc nang chua co san, vui long chon lai");
                    selectFunction(cccdNumber);
            }

        } catch (Exception e) {
            System.out.println(cccd + "Da xay ra loi hoac ban da chon chuc nang chua co san, Vui long chon lai chuc nang");
            selectFunction(cccdNumber);
        }
    }

    public void startCheckCCCD(Home home) {
        this.home = home;
        this.selectFunction(cccd);
    }

}
