package Lab11_1;

public class Car {
    private int cyclinders;
    private String name;
    private int wheel = 4;
    private boolean engine = true;
    public Car(int cyclinders, String name){
        this.cyclinders = cyclinders;
        this.name = name;
    }
    public String startEngine(){
        return getClass().getSimpleName() + " -> start engine";
    }

    public String accelerates(){
        return getClass().getSimpleName() + " -> accelerates";
    }

    public String breaks(){
        return getClass().getSimpleName() + " -> breaks";
    }

    public int getCyclinders() {
        return cyclinders;
    }

    public void setCyclinders(int cyclinders) {
        this.cyclinders = cyclinders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
