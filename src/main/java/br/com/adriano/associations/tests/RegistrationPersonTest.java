package br.com.adriano.associations.tests;

import br.com.adriano.associations.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationPersonTest {
    public static void main(String[] args) {
        System.out.println("Cadastro de pessoa");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("codekata");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person person = new Person("Maria");

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManagerFactory.close();
        System.out.println(person);
    }
}
