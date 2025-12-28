import java.util.Scanner;
interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

interface CustomerOperations {
    void displayCustomerDetails();
}


class BankAccount implements BankingOperations, CustomerOperations {

    private int accountNumber;
    private String customerName;
    private double balance;

    BankAccount(int accNo, String name, double bal) {
        accountNumber = accNo;
        customerName = name;
        balance = bal;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new ArithmeticException("Insufficient Balance");
        balance -= amount;
        System.out.println("Amount withdrawn successfully");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayCustomerDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double bal = sc.nextDouble();

            BankAccount acc = new BankAccount(accNo, name, bal);

            acc.displayCustomerDetails();
            acc.deposit(1000);
            acc.withdraw(500);
            acc.checkBalance();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
