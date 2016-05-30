package it.uniroma3.persistence;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import it.uniroma3.model.*;

@Stateless(name="eDao")
public class ExamDao {

	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Exam create(String name, String result, Date examDate, Typology typology, Patient patient, Doctor doctor) {
		Exam exam = new Exam(name, result, examDate, typology, patient, doctor);
		patient.addExamToPatient(exam);
		doctor.addExamToDoctor(exam);
		em.persist(exam);
		em.merge(patient);
		em.merge(doctor);
		return exam;
	}

	public Exam getExamByName(String ename) {
		Query q = em.createQuery("SELECT e FROM Exam e WHERE e.name = :ename");
		q.setParameter("name", ename);
		Exam e = (Exam) q.getSingleResult();
		return e;
	}
	
	public Exam findByPrimaryKey(Long code) {
		Exam e = this.em.find (Exam.class, code);
		return e;
	}

	public List<Exam> findAll() {
		TypedQuery<Exam> q = this.em.createQuery("SELECT e FROM Exam e", Exam.class);
		return q.getResultList();
	}

	public void update(Exam e) {
		this.em.merge(e);
	}
}