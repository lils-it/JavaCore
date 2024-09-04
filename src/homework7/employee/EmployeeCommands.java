package homework7.employee;

public interface EmployeeCommands {

//    0 for exit (0 սեղմելու դեպքում ծրագիրը վերջանալու է)
//1 add employee (1 սեղմելու դեպքում ուզելու է բոլոր տվյալները աշխատակից սարքելու, ու սարքելու է իրա օբյեկտը ու քցի EmployeeStorage-ի մեջ)
//2 print all employee(տպելու է բոլոր աշխատակիցներին)
//3 search employee by employee ID (փնտրելու է աշխատակից իր իդ-ով)
//4 search employee by company name  (տալու ենք ընկերության անունը, տպի իրա բոլոր աշխատակիցներին)

    String EXIT = "0";
    String ADD_NEW_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEES = "2";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_ID = "3";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME = "4";

    String EXIT_COMMAND = "Please input " + EXIT + " to Exit";
    String ADD_NEW_EMPLOYEE_COMMAND = "Please input " + ADD_NEW_EMPLOYEE + " to add employee";
    String PRINT_ALL_EMPLOYEES_COMMAND = "Please input " + PRINT_ALL_EMPLOYEES + " to print all employees";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_ID_COMMAND = "Please input " + SEARCH_EMPLOYEE_BY_EMPLOYEE_ID + " to search an employee by ID";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME_COMMAND = "Please input " + SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME + " to search an employee by Company name";

    static void printUserCommands() {
        System.out.println(EXIT_COMMAND);
        System.out.println(ADD_NEW_EMPLOYEE_COMMAND);
        System.out.println(PRINT_ALL_EMPLOYEES_COMMAND);
        System.out.println(SEARCH_EMPLOYEE_BY_EMPLOYEE_ID_COMMAND);
        System.out.println(SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME_COMMAND);
    }

}
