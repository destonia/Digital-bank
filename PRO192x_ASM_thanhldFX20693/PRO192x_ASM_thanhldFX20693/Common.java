package PRO192x_ASM_thanhldFX20693;

import PRO192x_ASM_thanhldFX20693.ASM2.Asm02;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Common {

    public static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
    public static void continueOrEnd() {
        boolean flag = true;
        do {
            System.out.println("Vui lòng nhập 'Y' để tiếp tục, 'N' để thoát: ");
            Scanner sc = new Scanner(System.in);
            String isContinue = sc.next();
            switch (isContinue) {
                case "Y":
                    flag = false;
                    Asm02.startApp();
                    break;
                case "N":
                    System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ của Ngân Hàng!");
                    flag = false;
                    break;
            }
        }
        while (flag);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            for (int i = 0; i < strNum.length(); i++) {
                if (!Character.isDigit(strNum.charAt(i))) {
                    return false;
                }
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String toFixedLength(int length, String str) {
        try {
            return String.join("", Collections.nCopies(length - str.length(), " ")) + str;
        } catch (Exception exception) {
            return "N/A";
        }
    }

    public static String formatCurrency(double amount) {
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            df.setRoundingMode(RoundingMode.HALF_UP);
            String strAmount = df.format(amount);
            if (strAmount.length() > 20){
                return "Số tiền quá lớn";
            }
            return strAmount + "đ";
        } catch (Exception e) {
            return "Số tiền quá lớn";
        }
    }

    public static String formatDate(Date date){
        return dateFormat.format(date);
    }

    public static String getCurrentDateTime(){
        return formatDate(Calendar.getInstance().getTime());
    }
}
