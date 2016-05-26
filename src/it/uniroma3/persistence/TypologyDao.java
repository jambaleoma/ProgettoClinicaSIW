package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Typology;

public class TypologyDao implements DAO<Typology>{

	public EntityManager em;

	public TypologyDao(EntityManager em) {
		this.em = em;
	}

	public void save(Typology typology) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(typology);
		tx.commit();
		this.em.close();
	}

	public Typology findByPrimaryKey(long code) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Typology t = this.em.find(Typology.class, code);
		tx.commit();
		this.em.close();
		return t;
	}

	public List<Typology> findAll() {
		List<Typology> t = em.createQuery("Typology.findAll").getResultList();
		this.em.close();
		return t;
	}

	public void update(Typology typology) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(typology);
		tx.commit();
		this.em.close();
	}

	public void delete(Typology typology) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(typology);
		tx.commit();
		this.em.close();
	}

}