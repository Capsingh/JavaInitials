import java.util.Scanner;

public class JavaDayTwo {

    public static void main(String[] args) {

        // hi this is my first change.

        Scanner scanner = new Scanner(System.in);
        boolean userChoice = true;

        // Main loop
        while (userChoice) {

            int input = getValidOperation(scanner);

            double a = getValidNumber(scanner,"first");
            double b = getValidNumber(scanner,"second");


            // Prevent division/remainder by zero
            if ((input == 4 || input == 5) && b == 0) {
                System.out.println("---------------------------------------------");
                System.out.println("You can't divide or find a remainder by zero.");
                System.out.println("----------------------------------------------");
                continue;
            }
            double result = calculate(a, b, input);
            String operation = getOperationName(input);
            // Display result
            System.out.println("-----------------------------------");
            System.out.println("Operation:" + operation);
            System.out.println("Your answer is " + result);
            System.out.println("-----------------------------------");

            // Play again loop
            while (true) {

                System.out.print("Do you want to play again (y/n): ");

                String option = scanner.next();

                if (option.equalsIgnoreCase("y")) {
                    break;
                } else if (option.equalsIgnoreCase("n")) {
                    System.out.println("------------------");
                    System.out.println("Thanks for playing");
                    System.out.println("------------------");
                    userChoice = false;
                    break;
                } else {
                    System.out.println("Enter a valid input");
                }
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("""
                                      Which action do you want to perform?
                                      1. Addition
                                      2. Subtraction
                                      3. Multiplication
                                      4. Division
                                      5. Remainder
                                       --------------------------------------\s
                                     \s""");
    }

    public static int getValidOperation(Scanner scanner){

        while(true) {
            showMenu();

            if (scanner.hasNextInt()) {

                int input = scanner.nextInt();

                if (input >= 1 && input <= 5) {
                    return input;
                } else {
                    System.out.println("Enter a valid option (1-5).");
                }
            } else {
                System.out.println("Enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
    }

    public static double getValidNumber(Scanner scanner, String numberName){


            while (true) {
                System.out.print("Enter the " + numberName + " number: ");

                if (scanner.hasNextDouble()) {
                    return scanner.nextDouble();
                }
                else {
                    System.out.println("-----------------------------");
                    System.out.println("Enter a valid number");
                    System.out.println("-----------------------------");
                    scanner.next(); // Clear invalid input
                }
            }
    }
    public static double calculate(double a, double b, int input){

        return switch (input) {
            case 1 -> a+b;
            case 2 -> a-b;
            case 3 -> a*b;
            case 4 -> a/b;
            case 5 -> a%b;
            default -> throw new IllegalArgumentException("Invalid operation: " + input);
        };
    }

    public static String getOperationName(int input){
            return switch(input){
                case 1-> "Addition";
                case 2-> "Subtraction";
                case 3-> "Multiplication";
                case 4-> "Division";
                case 5-> "Remainder";
                default -> "Invalid Operation:";
        };
    }
}
