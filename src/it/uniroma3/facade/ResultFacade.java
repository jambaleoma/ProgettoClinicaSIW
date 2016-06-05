package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Exam;
import it.uniroma3.model.Result;

@Stateless
public class ResultFacade {

	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;

	public Result createResult(String value, Exam exam) {
		Result result = new Result(value, exam);
		em.persist(result);
		return result;
	}

	public Result getResultById(long id) {
		Result result= em.find(Result.class, id);
		return result;
	}

	public List<Result> getAllResults() {
		CriteriaQuery<Result> cq = em.getCriteriaBuilder().createQuery(Result.class);
		cq.select(cq.from(Result.class));
		List<Result> results = em.createQuery(cq).getResultList();
		return results;
	}

	public void updateResult(Result result) {
		em.merge(result);
	}

	private void deleteResult(Result result) {
		em.remove(result);
	}

	public void deleteResultById(String id) {
		Result result = em.find(Result.class, id );
		deleteResult(result);
	}
}