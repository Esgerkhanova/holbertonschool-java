package models;

import entities.Student;

import javax.persistence.*;
import java.util.List;

public class StudentModel {

    private EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("course-management-jpa");
    }

    public void create(Student student) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Student findById(Long id) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Student> findAll() {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class);
            return q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Student student) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Student student) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student managed = em.find(Student.class, student.getId());
            if (managed != null) em.remove(managed);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
