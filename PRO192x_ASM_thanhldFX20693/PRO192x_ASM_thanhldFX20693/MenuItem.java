package PRO192x_ASM_thanhldFX20693;

public class MenuItem {
    private String name;
    private int number;
    public MenuItem(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
