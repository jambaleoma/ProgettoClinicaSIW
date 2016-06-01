package it.uniroma3.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.model.Administrator;
import it.uniroma3.persistence.AdministratorDao;

@ManagedBean
@SessionScoped
public class AdministratorController {
	
	@EJB(beanName="aDao")
	private AdministratorDao aDao;	
	private String username;
	private String password;
	private String fisrtName;
	private String lastName;
	private String eMail;
	private Administrator administrator;
	private String message;
	
	public String loginAdmin() {
		try {
			Administrator a = this.aDao.getAdministratorByUsername(this.username);
			if(a.verificaPassword(this.password)){
				this.setAdministrator(a);
				return "instrumentPanel";
				}
			else {
				this.message="Password errata";
				return "loginAdmin";
			}
		}catch (Exception e) {
			this.message= "Username errato";
			return "loginAdmin"; }
		}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}
	
	public String returnInstrumentPanel() {
		return "instrumentPanel";
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public AdministratorDao getaDao() {
		return aDao;
	}

	public void setaDao(AdministratorDao aDao) {
		this.aDao = aDao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
}