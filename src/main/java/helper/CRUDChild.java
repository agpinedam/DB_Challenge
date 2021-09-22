package helper;

import database.ChildrenQuery;
import entities.Children;

import java.sql.Date;
import java.util.List;

public class CRUDChild {

    protected Children children = new Children();
    protected ChildrenQuery childrenQuery = new ChildrenQuery();
    protected List<Children> resultsChildren;

    // no-argument constructor
    public CRUDChild() { }

    public void insertChild(int idChild, int idEmployee, String fullName, Date birthDate, String genre) {
        Boolean result = childrenQuery.addChild(idChild, idEmployee, fullName, birthDate, genre);

        if ( result == true )
            System.out.println(" Company Added ");
        else
            System.out.println(" Company NOT Added ");
    }

    public void getAllChildren() {
        resultsChildren = childrenQuery.getAllChildren();
        for (Children comp : resultsChildren) {
            System.out.print(comp.getIdChild()+"  -  ");
            System.out.print(comp.getIdEmployee()+"  -  ");
            System.out.print(comp.getFullName()+"  -  ");
            System.out.print(comp.getBirthDate()+"  -  ");
            System.out.println(comp.getGender());
        }
    }

    public void findChildById(int idChild) {
        children = childrenQuery.getChildById(idChild);
            System.out.print(children.getIdChild()+"  -  ");
            System.out.print(children.getIdEmployee()+"  -  ");
            System.out.print(children.getFullName()+"  -  ");
            System.out.print(children.getBirthDate()+"  -  ");
            System.out.println(children.getGender());
    }

    public void findChildByName(String fullName) {
        resultsChildren = childrenQuery.getChildrenName(fullName);
        for (Children comp : resultsChildren) {
            System.out.print(comp.getIdChild()+"  -  ");
            System.out.print(comp.getIdEmployee()+"  -  ");
            System.out.print(comp.getFullName()+"  -  ");
            System.out.print(comp.getBirthDate()+"  -  ");
            System.out.println(comp.getGender());
        }
    }

    public void updateChild(int idChild, int idEmployee, String fullName, Date birthDate, String genre) {
        Boolean result = childrenQuery.updateChild(idChild, idEmployee, fullName, birthDate, genre);
        if ( result == true )
            System.out.println(" Company Updated ");
        else
            System.out.println(" Company NOT Updated ");
    }

    public void deleteChild(int idChild) {
        int result = childrenQuery.deleteChild(idChild);

        if ( result == 1 )
            System.out.println(" Company Deleted ");
        else
            System.out.println(" Company NOT Deleted ");
    }
}
