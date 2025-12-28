import java.util.Scanner;
import java.io.*;

abstract class BankAccount {

    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;

    // Constructor
    BankAccount(int accNo, String name, double bal) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = bal;
    }

    // Abstract methods
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    // Concrete method
    void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
    }
}
class SavingsAccount extends BankAccount {

    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // Method Overriding
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
        System.out.println("Deposit Successful");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal Successful");
    }
}
class CurrentAccount extends BankAccount {

    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful");
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawal Successful");
    }
}


class FileManager {

    static void saveAccount(BankAccount acc) {
        try (FileWriter fw = new FileWriter("accounts.txt", true)) {
            fw.write(acc.accountNumber + "," +
                     acc.accountHolderName + "," +
                     acc.balance + "\n");
        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    static void displayAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No Account Data Found");
        }
    }
}


public class BankManagementSystem {

    // Method Overloading
    static void showMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Display Account");
        System.out.println("5. Display File Data");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;   // Runtime Polymorphism
        int choice;

        do {
            showMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    System.out.print("1. Savings  2. Current : ");
                    int type = sc.nextInt();

                    if (type == 1)
                        account = new SavingsAccount(accNo, name, bal);
                    else
                        account = new CurrentAccount(accNo, name, bal);

                    FileManager.saveAccount(account);
                    System.out.println("Account Created Successfully");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter Amount: ");
                        account.deposit(sc.nextDouble());
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter Amount: ");
                        account.withdraw(sc.nextDouble());
                    }
                    break;

                case 4:
                    if (account != null)
                        account.displayAccountDetails();
                    break;

                case 5:
                    FileManager.displayAccounts();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
