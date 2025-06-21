import java.util.Scanner;

public class EmployeeManagementSystem {

    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int id, String name, String position, double salary) {
            this.employeeId = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
        }
    }

    static class EmployeeArray {
        Employee[] employees;
        int size;

        public EmployeeArray(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        // Add employee
        public void addEmployee(Employee emp) {
            if (size >= employees.length) {
                System.out.println("Array is full. Cannot add more employees.");
                return;
            }
            employees[size++] = emp;
            System.out.println("Employee added.");
        }

        // Search employee by ID
        public Employee searchEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) return employees[i];
            }
            return null;
        }

        // Traverse
        public void listEmployees() {
            if (size == 0) {
                System.out.println("No employees found.");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete employee by ID
        public void deleteEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--size] = null;
                    System.out.println("Employee deleted.");
                    return;
                }
            }
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeArray employeeList = new EmployeeArray(100);

        while (true) {
            System.out.println("\n1. Add  2. Search  3. Delete  4. View All  5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Position, Salary: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String pos = sc.next();
                    double sal = sc.nextDouble();
                    employeeList.addEmployee(new Employee(id, name, pos, sal));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    Employee found = employeeList.searchEmployee(searchId);
                    System.out.println(found != null ? found : "Employee not found.");
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    employeeList.deleteEmployee(delId);
                    break;

                case 4:
                    System.out.println("Employee List:");
                    employeeList.listEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
