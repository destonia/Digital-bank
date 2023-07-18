package Lab10_3;

public class Entry {
    public static void main(String[] args) {
        Person p = new Person();
        p.setId(1001);
        p.setName("Quynh");
        p.setAge(24);
        p.setAddress("Ha Noi");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Address: " + p.getAddress());
    }
    /* parameterized constructor */
    /*
    public static void main(String[] args) {
        Person p = new Person(1001, "Quynh", 24, "Ha Noi");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Address: " + p.getAddress());
    }
    */
}
