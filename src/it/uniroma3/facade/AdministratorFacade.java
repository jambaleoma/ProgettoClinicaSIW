package it.uniroma3.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Administrator;

public class AdministratorFacade {

	public EntityManagerFactory emf;

	public AdministratorFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Administrator administrator) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(administrator);
		tx.commit();
		em.close();
	}

	public Administrator findByPrimaryKey(Long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Administrator a = em.find(Administrator.class, id);
		tx.commit();
		em.close();
		return a;
	}

	public List<Administrator> findAllAdmins() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Administrator> a = em.createQuery("select a from Administrator a", Administrator.class).getResultList();
		tx.commit();
		em.close();
		return a;
	}

	public void update(Administrator administrator) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(administrator);
		tx.commit();
		em.close();
	}

	public void delete(Administrator administrator) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(administrator);
		tx.commit();
		em.close();
	}

}