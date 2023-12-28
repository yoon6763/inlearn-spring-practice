package jpabook.jpashot;

import jpabook.jpashot.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        try {
            Order order = new Order();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}