package homework7.employee;

import java.util.Arrays;

public class EmployeeStorage {

    private Employee[] employees = new Employee[10];
    private Employee[] employeesSearchPool;
    private int size;

    public boolean isEmpty () {
        return  size == 0;
    }

    public Employee getEmployeeByID(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equalsIgnoreCase(employees[i].getEmployeeID())) {
                return employees[i];
            }
        }
        return null;
    }

    public void add(Employee employee) {
        if (employees.length == size){
            extendStorage();
        }
        employees[size++] = employee;
    }

    private void extendStorage() {
        employees = Arrays.copyOf(employees, size + 10);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee getEmployeeByCompanyName(String keyword) {

        for (int i = 0; i < size; i++) {
            if (employees[i].getCompanyName().toUpperCase().contains(keyword.toUpperCase())) {
               return employees[i];
            }
        }
        return null;
    }
}
