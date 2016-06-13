package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Administrator;

@Stateless
public class AdministratorFacade {

	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;

	public Administrator createAdministrator(String username, String password, String firstName, String lastName, String eMail) {
		Administrator administrator = new Administrator(username, password, firstName, lastName, eMail);
		em.persist(administrator);
		return administrator;
	}

	public Administrator getAdministratorByUsername(String username) {
		Administrator administrator = em.find(Administrator.class, username);
		return administrator;
	}

	public Administrator findDoctorById(Long id) {
		Administrator administrator = em.find(Administrator.class, id);
		return administrator;
	}
	
	public List<Administrator> getAllAdmins() {
		CriteriaQuery<Administrator> cq = em.getCriteriaBuilder().createQuery(Administrator.class);
		cq.select(cq.from(Administrator.class));
		List<Administrator> admins = em.createQuery(cq).getResultList();
		return admins;
	}

	public void updateAdministrator(Administrator administrator) {
		em.merge(administrator);
	}

	private void deleteAdministrator(Administrator administrator) {
		em.remove(administrator);
	}

	public void deleteAdministratorByUsername(String username) {
		Administrator administrator = em.find(Administrator.class, username);
		deleteAdministrator(administrator);
	}
}