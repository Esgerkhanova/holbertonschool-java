package models;

import entities.Course;

import javax.persistence.*;
import java.util.List;

public class CourseModel {

    private EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("course-management-jpa");
    }

    public void create(Course course) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Course findById(Long id) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Course.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Course> findAll() {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c", Course.class);
            return q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Course course) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Course course) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Course managed = em.find(Course.class, course.getId());
            if (managed != null) em.remove(managed);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
