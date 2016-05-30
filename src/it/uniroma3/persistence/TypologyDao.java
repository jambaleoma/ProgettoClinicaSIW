package it.uniroma3.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import it.uniroma3.model.*;

@Stateless(name="tDao")
public class TypologyDao {

	@PersistenceContext(unitName = "clinic-unit")
	public EntityManager em;

	public Typology create(Long code, String name, String details) {
		Typology typology = new Typology(code, name, details);
		this.em.persist(typology);
		return typology;
	}

	public Typology findByPrimaryKey(Long code) {
		Typology t = this.em.find(Typology.class, code);
		return t;
	}

	public List<Typology> findAll() {
		TypedQuery<Typology> q = this.em.createQuery("SELECT t FROM Typology t", Typology.class);
		return q.getResultList();
	}

	public void update(Typology typology) {
		this.em.merge(typology);
	}

	public void delete(Long code) {
		Typology t = this.findByPrimaryKey(code);
		this.em.remove(t);
	}
}