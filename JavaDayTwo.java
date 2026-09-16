import java.util.Scanner;

public class JavaDayTwo {

    public static void main(String[] args) {

        //hi this is my first change

        Scanner scanner = new Scanner(System.in);
        boolean userChoice = true;

        // Main loop
        while (userChoice) {

            double a;
            double b;

            // Validate first number
            while (true) {

                System.out.print("Enter the first number: ");

                if (scanner.hasNextDouble()) {
                    a = scanner.nextDouble();
                    break;
                } 
                else {
                    System.out.println("-----------------------------");
                    System.out.println("Enter a valid number");
                    System.out.println("-----------------------------");
                    scanner.next(); // Clear invalid input
                }
            }

            // Validate second number
            while (true) {

                System.out.print("Enter the second number: ");

                if (scanner.hasNextDouble()) {
                    b = scanner.nextDouble();
                    break;
                } 
                else {
                    System.out.println("-----------------------------");
                    System.out.println("Enter a valid number");
                    System.out.println("-----------------------------");
                    scanner.next(); // Clear invalid input
                }
            }

            // Show menu
            System.out.println("\nWhich action do you want to perform?");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Remainder");
            System.out.println("---------------------------------");

            int input = scanner.nextInt();

            // Prevent division/remainder by zero
            if ((input == 4 || input == 5) && b == 0) {
                System.out.println("You can't divide or find a remainder by zero.");
                continue;
            }

            // Perform operations
            double addition = a + b;
            double subtraction = a - b;
            double multiplication = a * b;
            double division = a / b;
            double remainder = a % b;

            // Store results in an array
            double[] result = {
                addition,
                subtraction,
                multiplication,
                division,
                remainder
            };

            // Display result
            System.out.println("-----------------------------------");

            switch (input) {
                case 1 -> System.out.println("Your result is: " + result[0]);
                case 2 -> System.out.println("Your result is: " + result[1]);
                case 3 -> System.out.println("Your result is: " + result[2]);
                case 4 -> System.out.println("Your result is: " + result[3]);
                case 5 -> System.out.println("Your result is: " + result[4]);
                default -> System.out.println("Enter a valid option");
            }

            System.out.println("-----------------------------------");

            // Play again loop
            while (true) {

                System.out.print("Do you want to play again (y/n): ");

                String option = scanner.next();

                if (option.equalsIgnoreCase("y")) {
                    break;
                } 
                else if (option.equalsIgnoreCase("n")) {
                    userChoice = false;
                    break;
                } 
                else {
                    System.out.println("Enter a valid input");
                }
            }
        }

        scanner.close();
    }
}

