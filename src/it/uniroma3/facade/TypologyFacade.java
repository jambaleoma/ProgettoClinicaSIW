package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import it.uniroma3.model.Typology;

@Stateless
public class TypologyFacade {

	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Typology create(Long code, String name, String details) {
		Typology typology = new Typology(code, name, details);
		em.persist(typology);
		return typology;
	}

	public Typology getTypologyByCode(Long code) {
		Typology typology = em.find(Typology.class, code);
		return typology;
	}

	public List<Typology> getAllTypologies() {
		CriteriaQuery<Typology> cq = em.getCriteriaBuilder().createQuery(Typology.class);
		cq.select(cq.from(Typology.class));
		List<Typology> typologies = em.createQuery(cq).getResultList();
		return typologies;
	}

	public void update(Typology typology) {
		em.merge(typology);
	}

	public void deleteTypology(Typology typology) {
		em.remove(typology);
	}
	
	public void deleteTypologuByCode(Long code) {
		Typology typology = em.find(Typology.class, code);
		deleteTypology(typology);
	}

}
