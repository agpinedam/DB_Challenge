package helper;

import database.EmployeeQuery;
import entities.Employee;

import java.sql.Date;
import java.util.List;

public class CrudEmployee {

    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsCompany;

    // no-argument constructor
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
        for (Employee comp : resultsCompany) {
            System.out.print(comp.getIdCompany()+"  -  ");
            System.out.print(comp.getFirstName()+"  -  ");
            System.out.print(comp.getPhoneNumber()+"  -  ");
            System.out.print(comp.getEmail()+"  -  ");
            System.out.println(comp.getAddress());
        }
    }

    public void findEmployeeById(int idComp) {
        employee = employeeQuery.getEmployeeById(idComp);
            System.out.print(employee.getIdCompany()+"  -  ");
            System.out.print(employee.getFirstName()+"  -  ");
            System.out.print(employee.getPhoneNumber()+"  -  ");
            System.out.print(employee.getEmail()+"  -  ");
            System.out.println(employee.getAddress());
    }

    public void findEmployeeByLastName(String coName) {
        resultsCompany = employeeQuery.getEmployeeByLastName(coName);
        for (Employee comp : resultsCompany) {
            System.out.print(comp.getIdCompany()+"  -  ");
            System.out.print(comp.getFirstName()+"  -  ");
            System.out.print(comp.getPhoneNumber()+"  -  ");
            System.out.print(comp.getEmail()+"  -  ");
            System.out.println(comp.getAddress());
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
