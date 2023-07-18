import java.util.Scanner;

public class Lab4_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("n is equal to 0");
        } else {
            if (n < 0) {
                System.out.println("n is a negative number");
            } else {
                System.out.println("n is a positive number");
            }
        }
    }
}
