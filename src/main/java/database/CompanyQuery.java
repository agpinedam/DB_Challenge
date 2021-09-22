package database;

import entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CompanyQuery {

    EntityManager entityManager;  // Variable para obtener la conexion.
    Company company;
    List<Company> listCompany = null;

    // constructor
    public CompanyQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager(); // abre la conexion con la BD.
        listCompany = new ArrayList<Company>();
    }

    public Boolean addCompany(int idComp, String coName, String phoneNumb, String email, String address)
    {
        company = new Company(idComp, coName, phoneNumb, email, address);

        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();

        return entityManager.contains(company);
    }

    public List<Company> getAllCompanies()
    {
        Query query=entityManager.createQuery("From Company");
        listCompany = (List<Company>) query.getResultList();
        return listCompany;
    }

    public Company getCompanybyId(int idComp)
    {
        company = entityManager.find(Company.class, idComp);
        return company;
    }

    public List<Company> getCompanybyName(String coName)
    {
        Query query=entityManager.createQuery("SELECT p FROM Company p WHERE p.coName = :coName");
        query.setParameter("coName", coName);
        listCompany = query.getResultList();
        return listCompany;
    }

    public Boolean updateCompany(int idComp, String coName, String phoneNumb, String email, String address)
    {
        Boolean result = false;
        company = new Company();

        company = entityManager.find(Company.class, idComp);
        if(company != null) {
            company.setCoName(coName);
            company.setPhoneNumber(phoneNumb);
            company.setEmail(email);
            company.setAddress(address);

            entityManager.getTransaction().begin();
            entityManager.merge(company);
            entityManager.getTransaction().commit();
            result = entityManager.contains(company);
        }
        else ;
        return result;
    }

    public int deleteCompany(int idComp)
    {
        int result = 0;
        company = new Company();

        company = entityManager.find(Company.class, idComp);
        if(company != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(company);
            entityManager.getTransaction().commit();
            result=1;
        }
        else ;
        return result;
    }
}
