package com.miniproject2;

import java.io.*;
import java.util.*;

public class EmployeeApp {
	private static final String FILE_NAME = "employees.txt";
	private static List<Employee> employeeList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		loadFromFile();
		if (login()) {
			while (true) {
				System.out.print("\n--- Employee Management System ---");
				System.out.print("\n1. Add Employee  \n2. Display All  \n3. Search by ID");
				System.out.print("\n4. Update Salary \n5. Delete Employee \n6. Sort (Name)");
				System.out.print("\n7. Departments  \n8. Exit");
				System.out.print("\nChoice: ");

				try {
					int choice = sc.nextInt();
					switch (choice) {
					case 1 -> addEmployee();
					case 2 -> displayAll();
					case 3 -> searchEmployee();
					case 4 -> updateSalary();
					case 5 -> deleteEmployee();
					case 6 -> sortByName();
					case 7 -> displayDepartments();
					case 8 -> {
						saveToFile();
						System.exit(0);
					}
					default -> System.out.println("Invalid choice.");
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					sc.nextLine();
				}
			}
		}
	}

	private static boolean login() {
		System.out.print("Username: ");
		String u = sc.next();
		System.out.print("Password: ");
		String p = sc.next();
		return u.equals("Vikash") && p.equals("Vikash2026@");
	}

	private static void addEmployee() throws EmployeeException {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		for (Employee e : employeeList) {
			if (e.getId() == id)
				throw new EmployeeException("ID already exists!");
		}

		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Department: ");
		String dept = sc.next();
		if (dept.trim().isEmpty())
			throw new EmployeeException("Department cannot be empty!");

		System.out.print("Salary: ");
		double sal = sc.nextDouble();
		if (sal <= 0)
			throw new EmployeeException("Salary must be positive!");

		employeeList.add(new Employee(id, name, dept, sal));
		saveToFile();
		System.out.println("Employee added and file updated.");
	}

	private static void displayAll() {
		if (employeeList.isEmpty())
			System.out.println("No records found.");
		employeeList.forEach(System.out::println);
	}

	private static void searchEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		employeeList.stream().filter(e -> e.getId() == id).findFirst().ifPresentOrElse(System.out::println,
				() -> System.out.println("Not found."));
	}

	private static void updateSalary() throws EmployeeException {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		for (Employee e : employeeList) {
			if (e.getId() == id) {
				System.out.print("New Salary: ");
				double sal = sc.nextDouble();
				if (sal <= 0)
					throw new EmployeeException("Salary must be positive!");
				e.setSalary(sal);
				saveToFile();
				System.out.println("Salary updated.");
				return;
			}
		}
		System.out.println("Employee not found.");
	}

	private static void deleteEmployee() {
		System.out.print("Enter ID to delete: ");
		int id = sc.nextInt();
		if (employeeList.removeIf(e -> e.getId() == id)) {
			saveToFile();
			System.out.println("Employee deleted.");
		} else {
			System.out.println("ID not found.");
		}
	}

	private static void sortByName() {
		employeeList.sort(Comparator.comparing(Employee::getName));
		System.out.println("Sorted by Name:");
		displayAll();
	}

	private static void displayDepartments() {
		Set<String> depts = new HashSet<>();
		employeeList.forEach(e -> depts.add(e.getDepartment()));
		System.out.println("Unique Departments: " + depts);
	}

	private static void saveToFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(employeeList);
		} catch (IOException e) {
			System.out.println("File Save Error: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private static void loadFromFile() {
		File file = new File(FILE_NAME);
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
				employeeList = (ArrayList<Employee>) ois.readObject();
			} catch (Exception e) {
				System.out.println("File Load Error: " + e.getMessage());
			}
		}
	}
}
