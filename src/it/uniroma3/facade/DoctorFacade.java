package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Doctor;

@Stateless
public class DoctorFacade {

	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Doctor create(String firstName, String lastName) {
		Doctor doctor = new Doctor(firstName, lastName);
		em.persist(doctor);
		return doctor;
	}

	public Doctor getDoctorByLastname(String lastName) {
		Doctor doctor = em.find(Doctor.class, lastName);
		return doctor;
	}

	public Doctor getDoctorById(Long id) {
		Doctor doctor = em.find(Doctor.class, id);
		return doctor;
	}

	public List<Doctor> getAllDoctors() {
		CriteriaQuery<Doctor> cq = em.getCriteriaBuilder().createQuery(Doctor.class);
		cq.select(cq.from(Doctor.class));
		List<Doctor> doctors = em.createQuery(cq).getResultList();
		return doctors;
	}

	public void updateDocotr(Doctor doctor) {
		em.merge(doctor);
	}

	private void deleteDoctor(Doctor doctor) {
		em.remove(doctor);
	}
	
	public void deleteDoctorByLastName(String lastName) {
		Doctor doctor = em.find(Doctor.class, lastName);
		deleteDoctor(doctor);				
	}
}
