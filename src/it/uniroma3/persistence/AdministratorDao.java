package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Administrator;

public class AdministratorDao implements DAO<Administrator>{

	private EntityManager em;

	public AdministratorDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(Administrator administrator) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(administrator);
		tx.commit();
		this.em.close();
	}

	public Administrator findByPrimaryKey(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Administrator a = this.em.find(Administrator.class, id);
		tx.commit();
		this.em.close();
		return a;
	}

	public List<Administrator> findAll() {
		List<Administrator> a = em.createQuery("Administrator.findAll").getResultList();
		this.em.close();
		return a;
	}

	public void update(Administrator administrator) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(administrator);
		tx.commit();
		this.em.close();
	}

	public void delete(Administrator administrator) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(administrator);
		tx.commit();
		this.em.close();
	}

}