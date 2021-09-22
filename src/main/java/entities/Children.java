package entities;

import javax.persistence.*;
import java.sql.Date;


@Entity (name = "Children")//Declara Entidad Company, que Representa una tabla en la Base de Datos
@Table(name="Children")
public class Children {
    @Id
    @Column(name = "idChild")
    protected int idChild;
    @Column(name = "idEmployee")
    protected int idEmployee;
    @Column(name = "fullName")
    protected String fullName;
    @Column(name = "birthDate")
    protected Date birthDate;
    @Column(name = "gender")
    protected String gender;

    public Children() {
    }

    public Children(int idChild, int idEmployee, String fullName, Date birthDate, String gender) {
        this.idChild = idChild;
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public int getIdChild() {
        return idChild;
    }

    public void setIdChild(int idChild) {
        this.idChild = idChild;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return "Persona [idPersona "+idChild+", nombre" +fullName;
    }
}
