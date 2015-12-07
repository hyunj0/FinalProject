import java.util.Scanner;

public class FindRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program finds the largest and smallest numbers.");

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        while(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 0)
                break;
            if (number < smallest)
                smallest = number;
            if (number > largest)
                largest = number;
        }

        if (smallest == Integer.MAX_VALUE && largest == Integer.MIN_VALUE) {
            System.out.println("smallest: n/a");
            System.out.println("largest: n/a");
        } else {
            System.out.println("smallest: " + smallest);
            System.out.println("largest: " + largest);
        }
    }

}