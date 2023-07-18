package Lab11_6;

public class Circle implements IShape {
    private double circular;

    public Circle(double circular) {
        this.circular = circular;
    }

    @Override
    public double getArea() {
        return 3.14 * circular * circular;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * circular;
    }
}
