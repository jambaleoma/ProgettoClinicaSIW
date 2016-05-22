package facade;

import model.Exam;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ExamFacade {

	public EntityManagerFactory emf;

	public ExamFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Exam exam) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(exam);
		tx.commit();
		em.close();
	}

	public Exam findByPrimaryKey(Long code) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Exam e = em.find(Exam.class, code);
		tx.commit();
		em.close();
		return e;
	}

	public List<Exam> findAllExams() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Exam> e = em.createQuery("select e from Exam e", Exam.class).getResultList();
		tx.commit();
		em.close();
		return e;
	}

	public void update(Exam exam) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(exam);
		tx.commit();
		em.close();
	}

	public void delete(Exam exam) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(exam);
		tx.commit();
		em.close();
	}

}