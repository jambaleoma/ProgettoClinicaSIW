package it.uniroma3.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Patient;

public class PatientFacade {

	public EntityManagerFactory emf;

	public PatientFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Patient patient) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(patient);
		tx.commit();
		em.close();
	}

	public Patient findByPrimaryKey(Long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Patient p = em.find(Patient.class, id);
		tx.commit();
		em.close();
		return p;
	}

	public List<Patient> findAllPatients() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Patient> p = em.createQuery("select p from Patient p", Patient.class).getResultList();
		tx.commit();
		em.close();
		return p;
	}

	public void update(Patient patient) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(patient);
		tx.commit();
		em.close();
	}

	public void delete(Patient patient) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(patient);
		tx.commit();
		em.close();
	}

}