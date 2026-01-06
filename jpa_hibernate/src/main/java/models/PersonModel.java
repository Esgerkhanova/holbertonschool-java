package com.techcamps.registrations.models;

import com.techcamps.registrations.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PersonModel {

    private EntityManager getEntityManager() {
        return Persistence
                .createEntityManagerFactory("admin-jpa")
                .createEntityManager();
    }

    public void create(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        p = em.merge(p);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public Person findById(Long id) {
        EntityManager em = getEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p;
    }

    public List<Person> findAll() {
        EntityManager em = getEntityManager();
        List<Person> list =
                em.createQuery("from Person", Person.class).getResultList();
        em.close();
        return list;
    }
}
