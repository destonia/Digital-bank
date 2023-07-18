package PRO192x_ASM_thanhldFX20693.ASM1;

public class AgeAndGenre {
    public String getAgeAndGenre(String ageGenreNumber){
        String result;
        char genre = ageGenreNumber.charAt(0);
        String age = ageGenreNumber.substring(1,3);
        switch (genre){
            case '0':
                result = "Nam | 19" + age;
                break;
            case '1':
                result = "Nu | 19" + age;
                break;
            case '2':
                result = "Nam | 20" + age;
                break;
            case '3':
                result = "Nu | 20" + age;
                break;
            case '4':
                result = "Nam | 21" + age;
                break;
            case '5':
                result = "Nu | 21" + age;
                break;
            case '6':
                result = "Nam | 22" + age;
                break;
            case '7':
                result = "Nu | 22" + age;
                break;
            case '8':
                result = "Nam | 23" + age;
                break;
            case '9':
                result = "Nu | 23" + age;
                break;
            default:
                result= "Khong tim thay du lieu";
        }
        return result;
    }

}
