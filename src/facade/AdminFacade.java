package facade;

import model.Admin;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AdminFacade {

	public EntityManagerFactory emf;

	public AdminFacade(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Admin admin) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(admin);
		tx.commit();
		em.close();
	}

	public Admin findByPrimaryKey(Long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Admin a = em.find(Admin.class, id);
		tx.commit();
		em.close();
		return a;
	}

	public List<Admin> findAllAdmins() {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Admin> a = em.createQuery("select a from Admin a", Admin.class).getResultList();
		tx.commit();
		em.close();
		return a;
	}

	public void update(Admin admin) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(admin);
		tx.commit();
		em.close();
	}

	public void delete(Admin admin) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(admin);
		tx.commit();
		em.close();
	}

}