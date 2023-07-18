package Lab10_2;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50,false);
        System.out.println("initial page count = " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(10);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(3);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());
    }
}
