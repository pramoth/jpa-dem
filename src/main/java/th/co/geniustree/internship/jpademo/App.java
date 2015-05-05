
package th.co.geniustree.internship.jpademo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Faculty f = new Faculty();
        f.setName("Computer.");
        
        List<Student> student = new ArrayList<>();
        student.add(new Student("Bom",f));
        student.add(new Student("Best",f));
        student.add(new Student("Ooo",f));
        student.add(new Student("Xxx",f));
        
       f.setStudents(student);
        em.persist(f);
        List<Student> resultList = em.createQuery("select s from Student s where s.name like :name")
                .setParameter("name", "B%").getResultList();
        System.out.println("-------------------->"+resultList.size());
        em.getTransaction().commit();
    }
}
