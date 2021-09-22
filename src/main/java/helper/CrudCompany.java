package helper;

import database.CompanyQuery;
import entities.Company;

import java.util.List;

public class CrudCompany {

    protected Company company = new Company();
    protected CompanyQuery companyQuery = new CompanyQuery();
    protected List<Company> resultsCompany;

    // no-argument constructor
    public CrudCompany() { }

    public void insertCompany(int idComp, String coName, String phoneNumb, String email, String address) {
        Boolean result = companyQuery.addCompany(idComp, coName, phoneNumb, email, address);

        if ( result == true )
            System.out.println(" Company Added ");
        else
            System.out.println(" Company NOT Added ");
    }

    public void getAllCompanies() {
        resultsCompany = companyQuery.getAllCompanies();
        for (Company comp : resultsCompany) {
            System.out.print(comp.getIdCompany()+"  -  ");
            System.out.print(comp.getCoName()+"  -  ");
            System.out.print(comp.getPhoneNumber()+"  -  ");
            System.out.print(comp.getEmail()+"  -  ");
            System.out.println(comp.getAddress());
        }
    }

    public void findCompanyId(int idComp) {
        company = companyQuery.getCompanybyId(idComp);
            System.out.print(company.getIdCompany()+"  -  ");
            System.out.print(company.getCoName()+"  -  ");
            System.out.print(company.getPhoneNumber()+"  -  ");
            System.out.print(company.getEmail()+"  -  ");
            System.out.println(company.getAddress());
    }

    public void findCompanyName(String coName) {
        resultsCompany = companyQuery.getCompanybyName(coName);
        for (Company comp : resultsCompany) {
            System.out.print(comp.getIdCompany()+"  -  ");
            System.out.print(comp.getCoName()+"  -  ");
            System.out.print(comp.getPhoneNumber()+"  -  ");
            System.out.print(comp.getEmail()+"  -  ");
            System.out.println(comp.getAddress());
        }
    }

    public void updateCompany(int idComp, String coName, String phoneNumb, String email, String address) {
        Boolean result = companyQuery.updateCompany(idComp, coName, phoneNumb, email, address);
        if ( result == true )
            System.out.println(" Company Updated ");
        else
            System.out.println(" Company NOT Updated ");
    }

    public void deleteCompany(int idComp) {
        int result = companyQuery.deleteCompany(idComp);

        if ( result == 1 )
            System.out.println(" Company Deleted ");
        else
            System.out.println(" Company NOT Deleted ");
    }
}
