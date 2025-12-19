import java.util.Scanner;

class BankAccount {

    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int number) {
        accountHolderName = name;
        accountNumber = number;
        balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new ArithmeticException();
        }
        balance -= amount;
    }

    public void displayBalance() {
        System.out.println(balance);
    }

    public void displayAccountDetails() {
        System.out.println(accountHolderName);
        System.out.println(accountNumber);
        System.out.println(balance);
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int accountNumber = sc.nextInt();

        BankAccount account = new BankAccount(name, accountNumber);

        int choice = sc.nextInt();

        try {
            switch (choice) {

                case 1:
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid Operation");
        }
    }
}
