package helper;

import database.EmployeeQuery;
import entities.Employee;

import java.sql.Date;
import java.util.List;

public class CrudEmployee {

    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsCompany;


    public CrudEmployee() { }

    public void insertEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber
            , String address, double salary, Date birthDate, int idCompany) {

        Boolean result = employeeQuery.addCompany(idEmployee,firstName,lastName,email,phoneNumber,address,salary,
                birthDate,idCompany);

        if ( result == true )
            System.out.println(" Company Added ");
        else
            System.out.println(" Company NOT Added ");
    }

    public void getAllEmployees() {
        resultsCompany = employeeQuery.getAllEmployees();
        for (Employee employee : resultsCompany) {
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
    }

    public void findEmployeeById(int idEmployee) {
        employee = employeeQuery.getEmployeeById(idEmployee);
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

    public void findEmployeeByLastName(String lastName) {
        resultsCompany = employeeQuery.getEmployeeByLastName(lastName);
        for (Employee employee : resultsCompany) {
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
    }

    public void updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                              String address, double salary, Date birthDate, int idCompany) {
        Boolean result = employeeQuery.updateEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,
                birthDate,idCompany);
        if ( result == true )
            System.out.println(" Company Updated ");
        else
            System.out.println(" Company NOT Updated ");
    }

    public void deleteEmployee(int idComp) {
        int result = employeeQuery.deleteEmployee(idComp);

        if ( result == 1 )
            System.out.println(" Company Deleted ");
        else
            System.out.println(" Company NOT Deleted ");
    }
}
