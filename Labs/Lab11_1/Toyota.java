package Lab11_1;

public class Toyota extends Car{
    public Toyota(int cylinders, String name){
        super(cylinders,name);
    }
    @Override
    public String startEngine(){
        return getClass().getSimpleName() + " ->start engine";
    }

    @Override
    public String accelerates() {
        return getClass().getSimpleName() + " ->accelerates";
    }

    @Override
    public String breaks() {
        return getClass().getSimpleName() + " ->breaks";
    }
}
