package Lab10_1;

public class Bed {
    private String style;
    private int pillow;
    private int height;
    private int sheet;
    private int quilt;

    public Bed(
            String style,
            int pillow,
            int height,
            int sheet,
            int quilt
    ) {
        this.style = style;
        this.pillow = pillow;
        this.height = height;
        this.sheet = sheet;
        this.quilt = quilt;
    }

    public void make() {
        System.out.println("The bed is in making");
    }

    public String getStyle() {
        return style;
    }

    public int getPillow() {
        return pillow;
    }

    public int getHeight() {
        return height;
    }

    public int getSheet() {
        return sheet;
    }

    public int getQuilt() {
        return quilt;
    }
}
