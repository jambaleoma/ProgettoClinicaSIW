package it.uniroma3.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import it.uniroma3.model.*;

@Stateless (name="dDao")
public class DoctorDao {

	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Doctor create(String firstName, String lastName) {
		Doctor doctor = new Doctor(firstName, lastName);
		this.em.persist(doctor);
		return doctor;
	}

	public Doctor getDoctorByLastname(String lastName) {
		Query q = em.createQuery("SELECT d FROM Doctor d WHERE d.lastname = :lastname");
		q.setParameter("lastname", lastName);
		Doctor d = (Doctor) q.getSingleResult();
		return d;
	}
	
	public Doctor findByPrimaryKey(Long id) {
		Doctor d = this.em.find(Doctor.class, id);
		return d;
	}

	public List<Doctor> findAll() {
		TypedQuery<Doctor> q = this.em.createQuery("SELECT d FROM Doctor d", Doctor.class);
		return q.getResultList();
	}

	public void update(Doctor doctor) {
		this.em.merge(doctor);
		}
}