package it.uniroma3.controller;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.facade.DoctorFacade;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

@ManagedBean(name = "doctorController")
public class DoctorController {
	
	@EJB
	private DoctorFacade dfacade;
	private Long id;
	private String firstName;
	private String lastName;
	private Map<String,Exam> esami;
	private Doctor doctor;
	private List<Doctor> doctors;
	
	public String createDoctor(){
		this.doctor = dfacade.create(firstName, lastName);
		return "doctor";
	}

	public String listDoctors() {
		this.setDoctors(dfacade.getAllDoctors());
		return "doctors"; 
	}

	public String findDoctor(Long id) {
		this.doctor = dfacade.getDoctorById(id);
		return "medico";
	}
	
	public String findDoctorByLastname(String lastname) {
		this.doctor = dfacade.getDoctorByLastname(lastname);
		return "medico";
	}
	
	public DoctorFacade getDfacade() {
		return dfacade;
	}

	public void setDfacade(DoctorFacade dfacade) {
		this.dfacade = dfacade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map<String, Exam> getEsami() {
		return esami;
	}

	public void setEsami(Map<String, Exam> esami) {
		this.esami = esami;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Long getid() {
		return id;
	}
	
}