package it.uniroma3.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import it.uniroma3.model.Patient;

@Stateless (name="pDao")
public class PatientDao {
	
	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Patient create(String username, String password, String firstName, String lastName, int dateOfBirth) {
		Patient patient = new Patient(username, password, firstName, lastName, dateOfBirth);
		this.em.persist(patient);
		return patient;
	}

	public Patient getPatientByUsername(String username) {
		Query q = em.createQuery("SELECT p FROM Patient p WHERE p.username = :username");
		q.setParameter("username", username);
		Patient p = (Patient) q.getSingleResult();
		return p;
	}
	
	public Patient findByPrimaryKey(Long id) {
		Patient p = this.em.find(Patient.class, id);
		return p;
	}

	public List<Patient> findAll() {
		TypedQuery<Patient> p = this.em.createQuery("SELECT p FROM Patient p", Patient.class);
		return p.getResultList();
	}

	public void update(Patient patient) {
		this.em.merge(patient);
		}

	public void delete(Patient patient) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(patient);
		tx.commit();
		this.em.close();
	}

}