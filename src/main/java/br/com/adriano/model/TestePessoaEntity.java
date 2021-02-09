package br.com.adriano.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePessoaEntity {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("codekata");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Pessoa pessoa1 = new Pessoa("Adriano");
		em.persist(pessoa1);
		em.getTransaction().commit();
		em.close();
	}

}
