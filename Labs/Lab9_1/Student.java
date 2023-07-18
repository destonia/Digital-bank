package Lab9_1;

public class Student extends Person {
    private double gpa;

    public Student(String name, int dob, double gpa) {
        // Call the constructor with 2 parameters
        super(name, dob);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
