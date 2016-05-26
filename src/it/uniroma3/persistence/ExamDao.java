package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Exam;

public class ExamDao implements DAO<Exam>{

	public EntityManager em;

	public ExamDao(EntityManager em) {
		this.em = em;
	}

	public void save(Exam exam) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(exam);
		tx.commit();
		this.em.close();
	}

	public Exam findByPrimaryKey(long code) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Exam e = this.em.find(Exam.class, code);
		tx.commit();
		this.em.close();
		return e;
	}

	public List<Exam> findAll() {
		List<Exam> e = em.createQuery("Exam.findAll").getResultList();
		this.em.close();
		return e;
	}

	public void update(Exam exam) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(exam);
		tx.commit();
		this.em.close();
	}

	public void delete(Exam exam) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.remove(exam);
		tx.commit();
		this.em.close();
	}

}