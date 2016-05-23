package it.uniroma3.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Doctor;

public class DoctorFacade {

	public EntityManagerFactory emf;

	public DoctorFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Doctor doctor) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(doctor);
		tx.commit();
		em.close();
	}

	public Doctor findByPrimaryKey(Long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Doctor d = em.find(Doctor.class, id);
		tx.commit();
		em.close();
		return d;
	}

	public List<Doctor> findAllDoctors() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Doctor> d = em.createQuery("select d from Doctor d", Doctor.class).getResultList();
		tx.commit();
		em.close();
		return d;
	}

	public void update(Doctor doctor) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(doctor);
		tx.commit();
		em.close();
	}

	public void delete(Doctor doctor) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(doctor);
		tx.commit();
		em.close();
	}

}