package mainTest;
import java.sql.Date;
;
import helper.CRUDChild;
import helper.CrudCompany;
import helper.CrudEmployee;

public class Principal {

    protected static CrudCompany crudCompany = new CrudCompany();
    protected static CRUDChild crudChild = new CRUDChild();
    protected static CrudEmployee crudEmployee = new CrudEmployee();

    public static void main(String[] args)
    {
       // crudCompany.getAllCompanies();
       // crudCompany.findCompanyId(3);
       // crudCompany.findCompanyName("Exito");
        //crudCompany.insertCompany(8, "Carrefur", "5893242", "carrefur@gmail.com", "14 trash rd.");
        //crudCompany.getAllCompanies();
       // crudCompany.updateCompany(8, "Jumbo", "789624", "jumbo@gmail.com", "27 trash rd.");
        //crudCompany.deleteCompany(8);
        //crudChild.deleteChild(7);
        //Date date =Date.valueOf("1996-08-31");
        //crudChild.insertChild( 7,74,"Dayana Maria",date,"female");
        //crudChild.findChildById(1);
        //crudChild.updateChild(7,92,"Dayana Maria",date,"masculine");
        //crudChild.findChildByName("Gohan");
        //crudChild.deleteChild(7);
        crudChild.getAllChildren();
        //crudChild.deleteChild(1);
        //crudEmployee.getAllEmployees();
    }
}
