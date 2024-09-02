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
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANYNAME= "4";

}
