package PRO192x_ASM_thanhldFX20693.ASM3.views;

import PRO192x_ASM_thanhldFX20693.MenuItem;

import java.util.Collections;
import java.util.Scanner;

public class Home {
    private static final String BANK_NAME = "NGAN HANG SO ";
    private static final String AUTHOR = "FX20693";
    private static final String VERSION = "@v3.0.0";

    private static final MenuItem[] MENU_ITEMS = {
            new MenuItem("Thong tin khach hang", 1),
            new MenuItem("Them tai khoan ATM", 2),
            new MenuItem("Them tai khoan tin dung", 3),
            new MenuItem("Rut tien", 4),
            new MenuItem("Lich su giao dich", 5),
            new MenuItem("Thoat", 0)};

    public static void showMainMenu(){
        String VERTICAL_LINE = "+" +
                String.join("", Collections.nCopies(10, "-")) +
                "+" + String.join("", Collections.nCopies(20, "-")) + "+" +
                String.join("", Collections.nCopies(10, "-")) + "+";
        String LEFT_BORDER = "| ";
        String RIGHT_BORDER = " |";
        String content = LEFT_BORDER + BANK_NAME + LEFT_BORDER + AUTHOR + VERSION;
        String blankSpace = String.join("", Collections.nCopies(VERTICAL_LINE.length() - content.length() - 2, " "));
        System.out.println(VERTICAL_LINE);
        System.out.print(content + blankSpace);
        System.out.println(RIGHT_BORDER);
        System.out.println(VERTICAL_LINE);
        for (MenuItem menuItem : MENU_ITEMS) {
            content = " " + menuItem.getNumber() + ". " + menuItem.getName();
            blankSpace = String.join("", Collections.nCopies(VERTICAL_LINE.length() - content.length() - 2, " "));
            System.out.println(content + blankSpace);
        }
        System.out.println(VERTICAL_LINE);
    }

    public static int selectFunction(){
        System.out.print("Chọn chức năng: ");
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }catch (Exception e){
            return -1;
        }
    }
}
