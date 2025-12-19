import java.util.Scanner;

public class BasicMathOperations {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static int square(int a) {
        return a * a;
    }

    public static int cube(int a) {
        return a * a * a;
    }

    public static int absolute(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println(add(firstNumber, secondNumber));
                break;

            case 2:
                System.out.println(subtract(firstNumber, secondNumber));
                break;

            case 3:
                System.out.println(multiply(firstNumber, secondNumber));
                break;

            case 4:
                System.out.println(divide(firstNumber, secondNumber));
                break;

            case 5:
                System.out.println(remainder(firstNumber, secondNumber));
                break;

            case 6:
                System.out.println(square(firstNumber));
                break;

            case 7:
                System.out.println(cube(firstNumber));
                break;

            case 8:
                System.out.println(absolute(firstNumber));
                break;
        }
    }
}
