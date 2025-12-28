import java.util.*;
import java.util.regex.Pattern;

interface EmployeeOperations {
    void addEmployee();
    void displayEmployees();
    void searchEmployee();
    void removeEmployee();
}

class EmployeeManager implements EmployeeOperations {

    Map<Integer, String> hashMap = new HashMap<>();
    Hashtable<Integer, String> hashtable = new Hashtable<>();
    TreeMap<Integer, String> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        hashMap.put(id, name);
        hashtable.put(id, name);
        treeMap.put(id, name);

        System.out.println("Employee Added");
    }

    public void displayEmployees() {
        System.out.println("HashMap: " + hashMap);
        System.out.println("Hashtable: " + hashtable);
        System.out.println("TreeMap: " + treeMap);
    }

    public void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.println("Found: " + hashMap.get(id));
    }

    public void removeEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        hashMap.remove(id);
        hashtable.remove(id);
        treeMap.remove(id);

        System.out.println("Employee Removed");
    }

    public static void main(String[] args) {

        EmployeeManager em = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: em.addEmployee(); break;
                case 2: em.displayEmployees(); break;
                case 3: em.searchEmployee(); break;
                case 4: em.removeEmployee(); break;
                case 5: System.out.println("Exit"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);

        sc.close();
    }
}
