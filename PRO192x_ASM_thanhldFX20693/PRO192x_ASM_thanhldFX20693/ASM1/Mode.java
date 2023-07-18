package PRO192x_ASM_thanhldFX20693.ASM1;

import PRO192x_ASM_thanhldFX20693.MenuItem;

import java.util.Collections;
import java.util.Scanner;

public class Mode {
    private final MenuItem[] MENU_ITEMS = {
            new MenuItem("EASY", 0),
            new MenuItem("HARD", 1)
    };

    private int selectedMode;

    public void displayMenu() {
        System.out.println("Vui long chon mot che do!");
        String indent = String.join("", Collections.nCopies(3, " "));
        String LEFT_BORDER = indent + "| ";
        for (MenuItem menuItem : MENU_ITEMS) {
            String content = LEFT_BORDER + menuItem.getNumber() + ". " + menuItem.getName();
            System.out.println(content);
        }
    }

    public void selectMode() {
        System.out.print("Che do: ");
        try {
            Scanner sc = new Scanner(System.in);
            int selectedMode = sc.nextInt();
            switch (selectedMode) {
                case 0:
                    this.selectedMode = 0;
                    break;
                case 1:
                    this.selectedMode = 1;
                    break;
                default:
                    System.out.println("Chuc nang chua co san, vui long chon lai");
                    selectMode();
            }
        } catch (Exception e) {
            System.out.println("Chuc nang chua co san, vui long chon lai");
            selectMode();
        }
    }

    public int getSelectedMode() {
        return selectedMode;
    }
}
