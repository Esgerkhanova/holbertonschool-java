package com.techcamps.registrations.models;

import com.techcamps.registrations.entities.Person;

import javax.persistence.*;
import java.util.List;

public class PersonModel {

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("admin-jpa").createEntityManager();
    }

    public void create(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public List<Person> findAll() {
        EntityManager em = getEntityManager();
        List<Person> list =
                em.createQuery("from Person", Person.class).getResultList();
        em.close();
        return list;
    }
}
