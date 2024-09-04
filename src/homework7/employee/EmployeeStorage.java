package homework7.employee;


import java.util.Arrays;

public class EmployeeStorage {

    private Employee[] employees = new Employee[10];
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public Employee getEmployeeByID(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equalsIgnoreCase(employees[i].getEmployeeID())) {
                return employees[i];
            }
        }
        return null;
    }

    private Employee getAnyEmployeeByCompanyKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompanyName().toUpperCase().contains(keyword.toUpperCase())) {
                return employees[i];
            }
        }
        return null;
    }

    private int getIndexOfEmployeesByKeyword(String keyword, Employee[] searchedEmployees, int index) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompanyName().toUpperCase().contains(keyword.toUpperCase())) {
                searchedEmployees[index++] = employees[i];
            }
        }
        return index;
    }

    public Employee[] getMultipleEmployeesByCompanyKeyword(String keyword) {
        if (getAnyEmployeeByCompanyKeyword(keyword) == null) {
            return new Employee[0];
        }
        int index = 0;
        Employee[] searchedEmployees = new Employee[size];
        index = getIndexOfEmployeesByKeyword(keyword, searchedEmployees, index);
        return Arrays.copyOf(searchedEmployees, index);
    }


    public void add(Employee employee) {
        if (employees.length == size) {
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

//    public Employee [] getEmployeesByCompanyName(String keyword) {
//        int count = 0;
//
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getCompanyName().toUpperCase().contains(keyword.toUpperCase())) {
//                count++;
//            }
//        }
//        if (count == 0) {
//            return new Employee[0]; //empty employee
//        }
//        Employee[] searchedEmployees = new Employee[count];
//
//        int index = 0;
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getCompanyName().toUpperCase().contains(keyword.toUpperCase())) {
//                searchedEmployees[index++] = employees[i];
//            }
//        }
//        return searchedEmployees;
//    }
}
