package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name="Employee")  //Declara Entidad Company, que Representa una tabla en la Base de Datos
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name = "idEmployee")
    protected int idEmployee;
    @Column(name = "firstName")
    protected String firstName;
    @Column(name = "lastName")
    protected String lastName;
    @Column(name = "email")
    protected String email;
    @Column(name = "phoneNumber")
    protected String phoneNumber;
    @Column(name = "address")
    protected String address;
    @Column (name = "Salary")
    protected int Salary;
    @Column (name = "birthDate")
    protected Date birthDate;
    @Column(name = "idCompany")
    protected int idCompany;

}
