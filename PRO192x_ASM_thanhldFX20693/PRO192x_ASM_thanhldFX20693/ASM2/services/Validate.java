package PRO192x_ASM_thanhldFX20693.ASM2.services;

import PRO192x_ASM_thanhldFX20693.Common;

public class Validate {
    public boolean validateCccd(String cccdNumber){
        try {
            if (String.valueOf(cccdNumber).length() == 12 && Common.isNumeric(cccdNumber)) {
                return true;
            } else {
                System.out.println("Số CCCD không hợp lệ,");
                return false;
            }
        } catch (Exception e) {
            System.out.println("da xay ra loi khong xac dinh, vui long thu lai");
            return false;
        }
    }
    public static boolean validateAccountNumber(String accountNumber){
        try {
            Common common = new Common();
            if (String.valueOf(accountNumber).length() == 6 && Common.isNumeric(accountNumber)) {
                return true;
            } else {
                System.out.println("Mã STK không hợp lệ,");
                return false;
            }
        } catch (Exception e) {
            System.out.println("da xay ra loi khong xac dinh, vui long thu lai");
            return false;
        }
    }

    public boolean validateBalanceNumber(Double balance){
        try {
            if (balance < 50000){
                return false;
            }
            return true;
        }catch (Exception e){
            System.out.println("Số tiền quá lớn hoặc sai định dạng, vui lòng thử lại!");
            return false;
        }
    }
}
