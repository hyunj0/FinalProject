import java.util.Scanner;

public class Collatz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCalculations = 0;

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        while (n != 1) {
            if (n % 2 == 0) {
                System.out.println(n + " is even, so I take half: " + (n / 2));
                n = n / 2;
            } else {
                System.out.println(n + " is odd, so I make 3n + 1: " + (3 * n + 1));
                n = 3 * n + 1;
            }
            numberOfCalculations++;
        }

        System.out.println("The process took " + numberOfCalculations + " calculations to reach 1");
    }

}