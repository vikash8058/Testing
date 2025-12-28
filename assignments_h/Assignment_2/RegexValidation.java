import java.util.Scanner;
import java.util.regex.Pattern;

class RegexValidation {

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (validate(mobile, "[6-9][0-9]{9}"))
                            System.out.println("Welcome! Valid Mobile Number");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        if (validate(email, "^[A-Za-z0-9+_.-]+@(.+)$"))
                            System.out.println("Welcome! Valid Email");
                        else
                            System.out.println("Invalid Email");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();
                        if (validate(username, "[A-Za-z0-9_]{5,15}"))
                            System.out.println("Welcome! Valid Username");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();
                        if (validate(password, "(?=.*[0-9])(?=.*[A-Z]).{6,}"))
                            System.out.println("Welcome! Strong Password");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        sc.close();
    }
}
