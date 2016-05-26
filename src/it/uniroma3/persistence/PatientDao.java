package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Patient;

public class PatientDao implements DAO<Patient>{

	public EntityManager em;

	public PatientDao(EntityManager em) {
		this.em = em;
	}

	public void save(Patient patient) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(patient);
		tx.commit();
		this.em.close();
	}

	public Patient findByPrimaryKey(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Patient p = this.em.find(Patient.class, id);
		tx.commit();
		this.em.close();
		return p;
	}

	public List<Patient> findAll() {
		List<Patient> p = em.createQuery("Patient.findAll").getResultList();
		this.em.close();
		return p;
	}

	public void update(Patient patient) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(patient);
		tx.commit();
		this.em.close();
	}

	public void delete(Patient patient) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(patient);
		tx.commit();
		this.em.close();
	}

}