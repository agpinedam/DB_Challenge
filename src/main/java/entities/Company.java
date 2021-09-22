package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Company")  //Declara Entidad Company, que Representa una tabla en la Base de Datos
@Table(name="Company")  // Anotacion para referirnos a la tabla en la base de Datos
public class Company {

    @Id
    @Column(name = "idCompany")
    protected int idCompany;
    @Column(name = "coName")
    protected String coName;
    @Column(name = "phoneNumber")
    protected String phoneNumber;
    @Column(name = "email")
    protected String email;
    @Column(name = "address")
    protected String address;

    // no-argument constructor
    public Company()
    {
    }

    public Company(int idCompany, String coName, String phoneNumber, String email, String address) {
        this.idCompany = idCompany;
        this.coName = coName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
