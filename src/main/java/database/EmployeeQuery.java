package database;

import entities.Employee;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmployeeQuery extends BaseQuery {

    private Employee employee;
    private List<Employee> listEmployee;
    private String tableName;
    private String columnLastName;


    public EmployeeQuery() {
        listEmployee = new ArrayList<>();
        tableName = "Employee";
        columnLastName = "lastName";
    }

    public boolean addEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                               String address, double salary, Date birthDate, int idCompany) {
        employee = new Employee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,idCompany);
        addObjectToTable(employee);
        return entityManager.contains(employee);
    }

    public List<Employee> getAllEmployees() {
        Query query = fomTable(tableName);
        listEmployee = query.getResultList();
        return listEmployee;
    }

    public Employee getEmployeeById(int idEmployee) {
        employee = findEmployee(idEmployee);
        return employee;
    }

    public List<Employee> getEmployeeByLastName(String lastName) {
        Query query = selectObjectFromTableByAttribute(tableName,columnLastName);
        setQueryParams(query,columnLastName,lastName);
        listEmployee = query.getResultList();
        return listEmployee;
    }

    public boolean updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber
            , String address, double salary, Date birthDate, int idCompany) {
        employee = createEmployee(idEmployee);
        if(employee != null) {
            setEmployee(firstName, lastName, email, phoneNumber, address, salary, birthDate, idCompany);
            updateObjectIntoTable(employee);
            return entityManager.contains(employee);
        }else {
            return false;
        }
    }

    public boolean deleteEmployee(int idEmployee) {
        employee = createEmployee(idEmployee);
        if(employee != null) {
            removeObjectToTable(employee);
            return true;
        }else {
            return false;
        }
    }

    private Employee createEmployee (int idEmployee){
        employee = new Employee();
         return findEmployee(idEmployee);
    }
    private Employee findEmployee (int idEmployee){
        return entityManager.find(Employee.class, idEmployee);
    }
    private void setEmployee(String firstName, String lastName, String email, String phoneNumber, String address,
                             double salary, Date birthDate, int idCompany){
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setBirthDate(birthDate);
        employee.setIdCompany(idCompany);
    }
}
