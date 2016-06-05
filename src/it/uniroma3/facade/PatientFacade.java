package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Patient;

@Stateless
public class PatientFacade {

	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;

	public Patient createPatient(String username, String password, String firstName, String lastName , Date dateOfBirth) {
		Patient patient = new Patient(username, password, firstName, lastName, dateOfBirth);
		em.persist(patient);
		return patient;
	}

	public Patient getPatientByUsername(String username) {
		Patient patient = em.find(Patient.class, username);
		return patient;
	}

	public Patient getPatientById(Long id) {
		Patient patient = em.find(Patient.class, id);
		return patient;
	}
	
	public List<Patient> getAllPatients() {
		CriteriaQuery<Patient> cq = em.getCriteriaBuilder().createQuery(Patient.class);
		cq.select(cq.from(Patient.class));
		List<Patient> patients = em.createQuery(cq).getResultList();
		return patients;
	}

	public void updatePatient(Patient patient) {
		em.merge(patient);
	}

	private void deletePatient(Patient patient) {
		em.remove(patient);
	}

	public void deletePatientByUsername(String username) {
		Patient patient = em.find(Patient.class, username);
		deletePatient(patient);
	}

}