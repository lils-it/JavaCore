package homework7.employee;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {

    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {

        employeeStorage.add(new Employee("Kate", "Kateson", "a001", 3700, "New Cola", "Accountant"));
        employeeStorage.add(new Employee("Billy", "Billson", "a002", 5670, "New Cola", "Manager"));
        employeeStorage.add(new Employee("Koko", "Jambo", "a003", 450, "Afri Cola", "Manager"));

        boolean isRunning = true;

        while (isRunning) {
            EmployeeCommands.printUserCommands();
            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    isRunning = false;
                    break;
                case ADD_NEW_EMPLOYEE:
                    addNewEmployee();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID:
                    searchEmployeeByID();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME:
                    searchEmployeeByCompanyname();
                    break;
                default:
                    System.out.println("Wrong command ! ");
            }
        }
    }

    private static void searchEmployeeByID() {
        System.out.println("Please input Employee ID ");
        String id = scanner.nextLine();

        if (employeeStorage.isEmpty()) {
            System.out.println("No employees in the storage! ");
            return;
        }
        Employee employee = employeeStorage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("No employee with id " + id + "was found ! ");
        } else System.out.println(employee);
    }

    private static void searchEmployeeByCompanyname() {
        System.out.println("Please input keyword for Company name ");
        String keyword = scanner.nextLine();

        if (employeeStorage.isEmpty()) {
            System.out.println("No employees in the storage! ");
            return;
        }
        Employee[] employeesSearched = employeeStorage.getMultipleEmployeesByCompanyKeyword(keyword);
        if (employeesSearched.length == 0) {
            System.out.println("No company name with keyword " + keyword + " was found! ");
        } else {
            for (Employee employee : employeesSearched) {
                System.out.println(employee);
            }
        }
    }

    private static void addNewEmployee() {
        System.out.println("Please input Employee ID ");
        String id = scanner.nextLine();

        Employee employeeByID = employeeStorage.getEmployeeByID(id);
        if (employeeByID == null) {
            String name = getString("Employee name");
            String surname = getString("Employee surname");
            String salaryStr = getString("Employee's salary");
            String companyname = getString("Company name");
            String position = getString("Employee position");

            if (!name.isEmpty() && !surname.isEmpty() && !companyname.isEmpty() && !salaryStr.isEmpty() && !position.isEmpty()) {
                double salary = Double.parseDouble(salaryStr);
                Employee employee = new Employee(name, surname, id, salary, companyname, position);
                employeeStorage.add(employee);
                System.out.println("New Employee successfully added ! ");
            } else System.out.println("Please try again and input full data");
        } else System.out.println("An employee with id " + id + " already exists! ");
    }

    private static String getString(String string) {
        System.out.println("Please input " + string);
        string = scanner.nextLine();
        return string;
    }

}
