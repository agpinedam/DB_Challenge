package database;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class BaseQuery {
    protected EntityManager entityManager;

    public BaseQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    protected void addObjectToTable(Object object){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }
    protected void removeObjectToTable(Object object){
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
    protected void updateObjectIntoTable(Object object){
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }
    protected Query fomTable(String tableName){
        return entityManager.createQuery("From " + tableName);
    }
    protected Query selectObjectFromTableByAttribute(String table,String columnName){
        return entityManager.createQuery("SELECT p FROM "+ table +" p WHERE p."+ columnName +" = :"+columnName);
    }
    protected void setQueryParams(Query query,String columnName, String attribute){
        query.setParameter(columnName , attribute);
    }
}
