import helper.CrudEmployee;
import java.sql.Date;

public class Principal {
    protected static CrudEmployee crudEmployee = new CrudEmployee();

    public static void main(String[] args)
    {
        crudEmployee.getAllEmployees();
        crudEmployee.insertEmployee(96,"Sofia","Cardenas","sofia@gmail.com",
                "6874165", "65 Abbey",4500.0, Date.valueOf("1973-01-10"),4);
        crudEmployee.updateEmployee(96,"Sofia","Martinez","sofia@gmail.com",
                "6874165", "65 Abbey",4500.0, Date.valueOf("1973-01-10"),4);
        crudEmployee.findEmployeeByLastName("Martinez");
        crudEmployee.deleteEmployee(96);
    }
}
