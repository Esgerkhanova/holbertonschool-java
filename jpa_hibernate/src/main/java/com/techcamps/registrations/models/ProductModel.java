package com.techcamps.registrations.models;

import com.techcamps.registrations.entities.Product;

import javax.persistence.*;
import java.util.List;

public class ProductModel {

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("admin-jpa").createEntityManager();
    }

    public void create(Product p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Product p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Product p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        p = em.merge(p);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public Product findById(Long id) {
        EntityManager em = getEntityManager();
        Product p = em.find(Product.class, id);
        em.close();
        return p;
    }

    public List<Product> findAll() {
        EntityManager em = getEntityManager();
        List<Product> list =
                em.createQuery("from Product", Product.class).getResultList();
        em.close();
        return list;
    }
}
