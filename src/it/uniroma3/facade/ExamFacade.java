package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;
import it.uniroma3.model.Patient;
import it.uniroma3.model.Typology;
	
	@Stateless
	public class ExamFacade {

		@PersistenceContext(unitName = "clinic-unit")
		public EntityManager em;

		public Exam create(Date bookingDate, Date examDate, Typology typology, Patient patient, Doctor doctor) {
			Exam exam = new Exam(bookingDate, null, typology, patient, doctor);
			patient.addExamToPatient(exam);
			doctor.addExamToDoctor(exam);
			em.persist(exam);
			em.merge(patient);
			em.merge(doctor);
			return exam;
		}

		public Exam getExamByCode(Long code) {
			Exam exam = em.find (Exam.class, code);
			return exam;
		}

		public List<Exam> getAllExams() {
	        CriteriaQuery<Exam> cq = em.getCriteriaBuilder().createQuery(Exam.class);
	        cq.select(cq.from(Exam.class));
	        List<Exam> exams = em.createQuery(cq).getResultList();
			return exams;
		}

		public void update(Exam exam) {
			em.merge(exam);
		}
		
		private void deleteExam(Exam exam) {
	        em.remove(exam);
	    }

		public void deleteExamByCode(Long code) {
			Exam exam = em.find(Exam.class, code);
	        deleteExam(exam);
		}
	}
