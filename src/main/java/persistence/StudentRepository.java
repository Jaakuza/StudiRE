package persistence;

import business.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepository {

    public static List<Student> getStudents(EntityManager entityManager) {
        TypedQuery<Student> query = entityManager.createNamedQuery(Student.findAll, Student.class);
        return query.getResultList();
    }

    public static Student getStudentById(EntityManager entityManager, Long id) {
        return entityManager.find(Student.class, id);
    }

    public static void addStudent(EntityManager entityManager, Student student) {
        entityManager.persist(student);
    }

    public static void removeStudent(EntityManager entityManager, Student student) {
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }

    public static void updateStudent(EntityManager entityManager, Student student) {
        entityManager.merge(student);
    }

    public static List<Student> findStudentsByName(EntityManager entityManager, String name) {
        TypedQuery<Student> query = entityManager.createNamedQuery(Student.findByName, Student.class);
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        return query.getResultList();
    }

}
