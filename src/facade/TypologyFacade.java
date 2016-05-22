package facade;

import model.Typology;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TypologyFacade {

	public EntityManagerFactory emf;

	public TypologyFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Typology typology) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(typology);
		tx.commit();
		em.close();
	}

	public Typology findByPrimaryKey(Long code) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Typology t = em.find(Typology.class, code);
		tx.commit();
		em.close();
		return t;
	}

	public List<Typology> findAllTypologies() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Typology> t = em.createQuery("select t from Typologies p", Typology.class).getResultList();
		tx.commit();
		em.close();
		return t;
	}

	public void update(Typology typology) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(typology);
		tx.commit();
		em.close();
	}

	public void delete(Typology typology) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(typology);
		tx.commit();
		em.close();
	}

}