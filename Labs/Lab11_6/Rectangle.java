package Lab11_6;

public class Rectangle implements IShape{
    private double height;
    private double width;
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    @Override
    public double getArea() {
        return height*width;
    }

    @Override
    public double getPerimeter() {
        return 2*(height+width);
    }
}
