package com.petermylemans.demos.identitycrisis;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SQLGenerationTest {


    @Test
    public void testUsingIdentity() throws Exception {
        System.out.println("=== SQL for inserting 5 entities using Identity ===");
        persistFiveElementsOf(EntityUsingIdentity.class);
    }

    @Test
    public void testUsingSequence() throws Exception {
        System.out.println("=== SQL for inserting 6 entities using Sequences ===");
        persistFiveElementsOf(EntityUsingSequenceGenerator.class);
    }

    @Test
    public void testUsingTable() throws Exception {
        System.out.println("=== SQL for inserting 5 entities using Table ===");
        persistFiveElementsOf(EntityUsingTableGenerator.class);
    }

    /**
     * Persist five elements of a specific clazz.
     *
     * @param clazz entity to persist
     * @throws Exception
     */
    private void persistFiveElementsOf(Class<?> clazz) throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("demo").createEntityManager();

        em.getTransaction().begin();

        for (int i = 0; i < 5; i++) {
            em.persist(clazz.newInstance());
        }

        em.flush();
        em.clear();

        em.getTransaction().rollback();
        em.close();
    }

}
