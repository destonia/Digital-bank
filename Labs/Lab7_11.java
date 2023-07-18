import java.util.Scanner;
public class Lab7_11 {
    public  static int[] getIntegers(int capacity){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[capacity];
        for (int i =0; i< capacity; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[] sortArray(int[] arr){
        for (int i = 0 ; i < arr.length; i++){
            for (int j = i + 1; j< arr.length; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please set array's size");
        int capacity = sc.nextInt();
        System.out.println("Please type in array's items");
        int[] arr = getIntegers(capacity);
        System.out.println("Input: ");
        for (int item: arr) {
            System.out.print(item + ",");
        }
        int[] sortArray = sortArray(arr);
        System.out.println("Output: ");
        for (int item: sortArray) {
            System.out.print(item + ",");
        }
    }
}
