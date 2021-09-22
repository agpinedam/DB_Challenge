package database;

import entities.Children;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ChildrenQuery {

    EntityManager entityManager;  // Variable para obtener la conexion.
    Children children;
    List<Children> listChildren = null;

    // constructor
    public ChildrenQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager(); // abre la conexion con la BD.
        listChildren = new ArrayList<Children>();
    }

    public Boolean addChild(int idChild, int idEmployee, String fullName, Date birthDate, String genre)
    {
        children = new Children(idChild, idEmployee, fullName, birthDate, genre);

        entityManager.getTransaction().begin();
        entityManager.persist(children);
        entityManager.getTransaction().commit();

        return entityManager.contains(children);
    }

    public List<Children> getAllChildren()
    {
        Query query=entityManager.createQuery("From Children");
        listChildren = (List<Children>) query.getResultList();
        return listChildren;
    }

    public Children getChildById(int idChild)
    {
        children = entityManager.find(Children.class, idChild);
        return children;
    }

    public List<Children> getChildrenName(String fullName)
    {
        Query query=entityManager.createQuery("SELECT p FROM Children p WHERE p.fullName = :fullName");
        query.setParameter("fullName", fullName);
        listChildren = query.getResultList();
        return listChildren;
    }

    public Boolean updateChild(int idChild, int idEmployee, String fullName, Date birthDate, String genre)
    {
        Boolean result = false;
        children = new Children();

        children = entityManager.find(Children.class, idChild);
        if(children != null) {
            children.setIdEmployee(idEmployee);
            children.setFullName(fullName);
            children.setBirthDate(birthDate);
            children.setBirthDate(birthDate);
            children.setGender(genre);

            entityManager.getTransaction().begin();
            entityManager.merge(children);
            entityManager.getTransaction().commit();
            result = entityManager.contains(children);
        }
        else ;
        return result;
    }

    public int deleteChild(int idChild)
    {
        int result = 0;
        children = new Children();

        children = entityManager.find(Children.class, idChild);
        if(children != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(children);
            entityManager.getTransaction().commit();
            result=1;
        }
        else ;
        return result;
    }
}
