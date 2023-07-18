package Lab11_1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(6,"Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerates());
        System.out.println(car.breaks());
        Honda honda = new Honda(4,"i10");
        System.out.println(honda.startEngine());
        System.out.println(honda.accelerates());
        System.out.println(honda.breaks());
        Toyota toyota = new Toyota(4,"Toyota 333");
        System.out.println(toyota.startEngine());
        System.out.println(toyota.accelerates());
        System.out.println(toyota.breaks());
    }

}
