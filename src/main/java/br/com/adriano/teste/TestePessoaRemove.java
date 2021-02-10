package br.com.adriano.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.adriano.model.Pessoa;

public class TestePessoaRemove {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("codekata");
		EntityManager em = emf.createEntityManager();

		//cadastra conta
		em.getTransaction().begin();
		Pessoa pessoa1 = new Pessoa("Fulano");
		em.persist(pessoa1);
		em.getTransaction().commit();
		System.out.println(pessoa1.getNome());
		
		Pessoa pessoRemovida = em.find(Pessoa.class, pessoa1.getId());
		em.getTransaction().begin();
		em.remove(pessoRemovida);
		em.getTransaction().commit();

		em.close();
		
	}

}
