package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Administrator;
import it.uniroma3.model.Typology;
import it.uniroma3.model.Doctor;
import it.uniroma3.persistence.TypologyDao;
import it.uniroma3.persistence.DoctorDao;

@ManagedBean
public class TypologyController {

	@EJB(beanName="pDao")
	private TypologyDao typologyDao;

	@EJB(beanName="dDao")
	private DoctorDao docotrDao;

	@ManagedProperty(value="{param.id}")
	private Long code;

	private String name;
	private String details;
	private List<Typology> typologies;
	private Typology typology;
	private String message;
	private List<Doctor> doctors;
	private List<Doctor> doctorsByTypology;
	
	@ManagedProperty(value="#{sessionScope['administratorController'].administrator}")
	private Administrator admin;
	
	@ManagedProperty(value="#{param.doctorid}")
	private Long doctorId;

	public String doctorEditor () {
		this.typology = this.typologyDao.findByPrimaryKey(this.code);
		this.doctors = this.docotrDao.findAll();
		this.doctorsByTypology = this.typology.getDoctors();
		return "doctorEditor";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String createTypology() {
		try {
			this.typology = this.typologyDao.create(code, name, details);
			return "typologyAdmin";
		}
		catch(Exception e) {
			this.message = "Tipologia gia' esistente";
			return "newTypology";
		}
	}

	public String updateTypology() {
		Typology t = this.typologyDao.findByPrimaryKey(this.code);
		t.setDetails(this.details);
		this.typologyDao.update(t);
		this.typologies = this.typologyDao.findAll();
		return "allTypologiesAdmin";
	}
	
	public String deleteTypology() {
		this.typologyDao.delete(this.code);
		this.typologies = this.typologyDao.findAll();
		return "allTypologiesAdmin";
	}
	
	public String listTypologies() {
		this.typologies = this.typologyDao.findAll();
		if (this.admin==null)
			return "allTypologyies";
		else return "allTypologiesAdmin";
	}
	
	public String getTypologyByCode () {
		this.typology = this.typologyDao.findByPrimaryKey(this.code);
		if (this.admin==null)
			return "typology";
		else {
			this.details = this.typology.getDetails();
			return "typologyAdmin";
		}
	}
	
	public String addDoctor () {
		Doctor d = this.docotrDao.findByPrimaryKey(this.doctorId);
		Typology ty = this.typologyDao.findByPrimaryKey(this.code);
		if (ty.checkDoctor(d)) {
			ty.addTypologyToDoctor(d);
			d.addDoctorToTypology(ty);
			this.typologyDao.update(ty);
			this.docotrDao.update(d);
		}
		return this.doctorEditor();
	}
	
	//METODS GETTER & SETTER
	
	public TypologyDao getTypologyDao() {
		return typologyDao;
	}

	public void setTypologyDao(TypologyDao typologyDao) {
		this.typologyDao = typologyDao;
	}

	public DoctorDao getDocotrDao() {
		return docotrDao;
	}

	public void setDocotrDao(DoctorDao docotrDao) {
		this.docotrDao = docotrDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Typology> getTypologies() {
		return typologies;
	}

	public void setTypologies(List<Typology> typologies) {
		this.typologies = typologies;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Long getCode() {
		return code;
	}

	public List<Doctor> getDoctorsByTypology() {
		return doctorsByTypology;
	}

	public void setDoctorsByTypology(List<Doctor> doctorsByTypology) {
		this.doctorsByTypology = doctorsByTypology;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
}
