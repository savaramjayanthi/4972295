class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[size++] = employee;
    }

    // Search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement(5);

        Employee e1 = new Employee(1, "Alice", "Manager", 70000);
        Employee e2 = new Employee(2, "Bob", "Developer", 50000);
        Employee e3 = new Employee(3, "Charlie", "Analyst", 60000);

        management.addEmployee(e1);
        management.addEmployee(e2);
        management.addEmployee(e3);

        System.out.println("All employees:");
        management.traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        System.out.println(management.searchEmployee(2));

        System.out.println("\nDeleting employee with ID 2.");
        management.deleteEmployee(2);

        System.out.println("All employees after deletion:");
        management.traverseEmployees();
    }
}

