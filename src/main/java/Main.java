import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            House house = new House();
            house.setId(4);
            house.setName("Slytherin");


            Person person1 = new Person();
            person1.setId(109);
            person1.setFirstName("James");
            person1.setLastName("Sirius Potter");
            person1.setHouse(house);
            System.out.println("James creado");

            Person person2 = new Person();
            person2.setId(110);
            person2.setFirstName("Albus");
            person2.setLastName("Severus Potter");
            person2.setHouse(house);
            System.out.println("Albus creado");


            Person person3 = new Person();
            person3.setId(111);
            person3.setFirstName("Lily");
            person3.setLastName("Luna Potter");
            person3.setHouse(house);
            System.out.println("Lily creado");

            em.persist(person1);
            em.persist(person2);
            em.persist(person3);



            //Segunda parte del ejercicio

            /*Person teacher = new Person();
            em.find(Person.class,101);
            Course course = new Course();
            course.setId(6);

            EnrollmentId enrollmentid = new EnrollmentId();
            enrollmentid.setCourseEnrollment(course.getId());
            enrollmentid.setPersonEnrollment(person3.getId());


            Enrollment enrollment = new Enrollment();
            enrollment.setId(enrollmentid);
            enrollment.setCourseEnrollment(course);
            enrollment.setPersonEnrollment(person3);

            em.persist(enrollment);*/

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}