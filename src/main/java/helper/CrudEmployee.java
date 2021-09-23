package helper;

import database.EmployeeQuery;
import entities.Employee;
import java.sql.Date;
import java.util.List;

public class CrudEmployee {

    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsCompany;


    public CrudEmployee() { }

    public void insertEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber
            , String address, double salary, Date birthDate, int idCompany) {
        boolean result = employeeQuery.addEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,
                birthDate,idCompany);
        message(result,"Added");
    }

    public void getAllEmployees() {
        resultsCompany = employeeQuery.getAllEmployees();
        printHeadersInfo();
        for (Employee employee : resultsCompany) {
            printAllInformation(employee);
        }
    }

    public void findEmployeeByLastName(String lastName) {
        resultsCompany = employeeQuery.getEmployeeByLastName(lastName);
        printHeadersInfo();
        for (Employee employee : resultsCompany) {
            printAllInformation(employee);
        }

    }

    public void updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                              String address, double salary, Date birthDate, int idCompany) {
        boolean result = employeeQuery.updateEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,
                birthDate,idCompany);
        message(result,"Update");
    }

    public void deleteEmployee(int idEmployee) {
        boolean result = employeeQuery.deleteEmployee(idEmployee);
        message(result,"Deleted");
    }

    private void printAllInformation (Employee employee){
        System.out.println(employee.getIdEmployee()+"\t"+
                        employee.getFirstName() + "\t\t" +
                        employee.getLastName() + "\t\t" +
                        employee.getEmail() + "\t\t" +
                        employee.getPhoneNumber() + "\t\t" +
                        employee.getAddress() + "\t\t" +
                        employee.getSalary() + "\t\t" +
                        employee.getBirthDate() + "\t\t" +
                        employee.getIdCompany());
    }
    private void printHeadersInfo(){
        System.out.println("\nid" + "\t" + "First Name" + "\t" + "Last Name" + "\t" + "Email" + "\t\t\t\t"
                + "Phone number" + "\t" + "Address" + "\t\t\t\t" + "Salary" + "\t\t" + "Birth Date" + "\t" + "idCompany");
    }
    private void message(boolean result, String action){
        if (result)
            System.out.println("\nEmployee was " + action);
        else
            System.out.println(" Employee was NOT " + action);
    }

}
