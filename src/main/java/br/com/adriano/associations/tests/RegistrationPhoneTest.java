package br.com.adriano.associations.tests;

import br.com.adriano.associations.model.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationPhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone("11 11111-1111");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("codekata");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(phone);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
