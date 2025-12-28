import java.util.*;
import java.util.regex.Pattern;

interface StudentOperations {
    void addStudent();
    void displayStudents();
    void searchStudent();
    void removeStudent();
}

class StudentManager implements StudentOperations {

    List<String> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();

        if (!Pattern.matches("[0-9]+", roll)) {
            System.out.println("Invalid Roll Number");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.add(roll + " - " + name);
        System.out.println("Student Added");
    }

    public void displayStudents() {
        System.out.println("Student Records:");
        for (String s : students)
            System.out.println(s);
    }

    public void searchStudent() {
        System.out.print("Enter Roll No to Search: ");
        String roll = sc.nextLine();

        for (String s : students) {
            if (s.startsWith(roll + " ")) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    public void removeStudent() {
        System.out.print("Enter Roll No to Remove: ");
        String roll = sc.nextLine();

        Iterator<String> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().startsWith(roll + " ")) {
                it.remove();
                System.out.println("Student Removed");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    public static void main(String[] args) {

        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: sm.addStudent(); break;
                case 2: sm.displayStudents(); break;
                case 3: sm.searchStudent(); break;
                case 4: sm.removeStudent(); break;
                case 5: System.out.println("Exit"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);

        sc.close();
    }
}
