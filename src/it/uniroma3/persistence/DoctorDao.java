package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Doctor;

public class DoctorDao implements DAO<Doctor>{

	public EntityManager em;

	public DoctorDao(EntityManager em) {
		this.em = em;
	}

	public void save(Doctor doctor) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(doctor);
		tx.commit();
		this.em.close();
	}

	public Doctor findByPrimaryKey(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Doctor d = this.em.find(Doctor.class, id);
		tx.commit();
		this.em.close();
		return d;
	}

	public List<Doctor> findAll() {
		List<Doctor> d = em.createQuery("Doctor.findAll").getResultList();
		this.em.close();
		return d;
	}

	public void update(Doctor doctor) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(doctor);
		tx.commit();
		this.em.close();
	}

	public void delete(Doctor doctor) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(doctor);
		tx.commit();
		this.em.close();
	}

}