package it.uniroma3.persistence;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Patient;

public class PatientDao {
	
	private EntityManager em;
		private static EntityTransaction tx;

		public PatientDao(EntityManager em) {
			this.em = em;
		}
		
	public void save(Patient p) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		
	}

	public void delete(Patient p) {
		tx = em.getTransaction();
		tx.begin();
		Patient toRemove = em.merge(p);
		em.remove(toRemove);
		tx.commit();
		}
	
	public void update(Patient p) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(p);
		tx.commit();

	}
	
	public Patient findByUsername(String username) {
		tx = em.getTransaction();
		tx.begin();
		Patient p = em.find(Patient.class, username);
		tx.commit();
		return p;
	}
	
	
	
}