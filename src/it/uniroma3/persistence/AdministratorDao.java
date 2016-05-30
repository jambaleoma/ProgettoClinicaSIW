package it.uniroma3.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import it.uniroma3.model.Administrator;

@Stateless(name="aDao")
public class AdministratorDao {

	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;

	public Administrator create(String username, String password, String firstName, String lastName, String eMail) {
		Administrator administrator = new Administrator(username, password, firstName, lastName, eMail);
		this.em.persist(administrator);
		return administrator;
	}
	
	public Administrator getAdministratorByUsername(String username) {
		Query q = em.createQuery("SELECT a FROM Administrator a WHERE a.username = :username");
		q.setParameter("username", username);
		return (Administrator) q.getSingleResult();
	}
	
	public Administrator findByPrimaryKey(Long id) {
		Administrator a = this.em.find(Administrator.class, id);
		return a;
	}

	public List<Administrator> findAll() {
		TypedQuery<Administrator> q = this.em.createQuery("SELECT a FROM Administrator a", Administrator.class);
		return q.getResultList();
	}

	public void update(Administrator administrator) {
		this.em.merge(administrator);
		}
}