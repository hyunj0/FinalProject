import java.util.Scanner;

public class PythagoreanTheorem {

    public static double calculateC (double a, double b) {
        double squareA = a * a;
        double squareB = b * b;
        return Math.sqrt(squareA+squareB);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values to compute the Pythagorean theorem.");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.println("c = " + calculateC(a, b));
    }

}