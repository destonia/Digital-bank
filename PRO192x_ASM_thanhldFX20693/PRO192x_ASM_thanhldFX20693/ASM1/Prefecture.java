package PRO192x_ASM_thanhldFX20693.ASM1;

public class Prefecture {
    private final String[][] prefectures = {{"001", "Ha Noi"}, {"002", "Ha Giang"}, {"003", "Cao Bang"}, {"004", "Bac Kan"}, {"005", "Tuyen Quang"}, {"006", "Lao Cai"}, {"007", "Dien Bien"}, {"008", "Lai Chau"}, {"009", "Son La"}, {"010", "Yen Bai"}, {"011", "Hoa Binh"}, {"012", "Thai Nguyen"}, {"013", "Lang Son"}, {"014", "Quang Ninh"}, {"015", "Bac Giang"}, {"016", "Phu Tho"}, {"017", "Vinh Phuc"}, {"018", "Bac Ninh"}, {"019", "Hai Duong"}, {"020", "Hai Phong"}, {"021", "Hung Yen"}, {"022", "Thai Binh"}, {"023", "Ha Nam"}, {"024", "Nam Dinh"}, {"025", "Ninh Binh"}, {"026", "Thanh Hoa"}, {"027", "Nghe An"}, {"028", "Ha Tinh"}, {"029", "Quang Binh"}, {"030", "Quang Tri"}, {"031", "Thua Thien Hue"}, {"032", "Da Nang"}, {"033", "Quang Nam"}, {"034", "Quang Ngai"}, {"035", "Binh Dinh"}, {"036", "Phu Yen"}, {"037", "Khanh Hoa"}, {"038", "Ninh Thuan"}, {"039", "Binh Thuan"}, {"040", "Kon tum"}, {"041", "Gia Lai"}, {"042", "Dak Lak"}, {"043", "Dak Nong"}, {"044", "Lam Dong"}, {"045", "Binh Phuoc"}, {"046", "Tay Ninh"}, {"047", "Binh Duong"}, {"048", "Dong Nai"}, {"049", "Ba Ria - Vung Tau"}, {"050", "Ho Chi Minh"}, {"051", "Long An"}, {"052", "Tien Giang"}, {"053", "Ben Tre"}, {"054", "Tra Vinh"}, {"055", "Vinh Long"}, {"056", "Dong Thap"}, {"057", "An Giang"}, {"058", "Kien Giang"}, {"059", "Can Tho"}, {"060", "Hau Giang"}, {"061", "Soc Trang"}, {"062", "Bac Lieu"}, {"063", "Ca Mau"},};

    public String[][] Prefecture() {
        return this.prefectures;
    }

    public String getPrefecture(String preNumber) {
        String result = "Khong tim thay du lieu";
        String[][] prefectures = this.prefectures;
        for (String[] prefecture : prefectures) {
            if (prefecture[0].equals(preNumber)) {
                result = prefecture[1];
            }
        }
        return result;
    }

    public String[][] getPrefectures() {
        return prefectures;
    }

}
