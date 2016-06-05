package it.uniroma3.controller;

//Home controller

import it.uniroma3.model.Administrator;
import it.uniroma3.model.Clinic;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;
import it.uniroma3.model.Patient;
import it.uniroma3.model.Typology;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeController {
	
	@EJB
	private Clinic clinic;
	private Patient currentPatient;
	private Typology currentTypology;
	private Exam currentExam;
	private Doctor currentDoctor;
	private Administrator currentAdmin;
		
	
	public HomeController() {}
	
	public HomeController(Clinic clinic, Patient currentPatient, Typology currentTypology,
			Exam currentExam, Doctor currentDoctor, Administrator currentAdmin) {
		super();
		this.clinic = clinic;
		this.currentPatient = currentPatient;
		this.currentTypology = currentTypology;
		this.currentExam = currentExam;
		this.currentDoctor = currentDoctor;
		this.currentAdmin = currentAdmin;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public Typology getCurrentTypology() {
		return currentTypology;
	}

	public void setCurrentTypology(Typology currentTypology) {
		this.currentTypology = currentTypology;
	}

	public Exam getCurrentExam() {
		return currentExam;
	}

	public void setCurrentExam(Exam currentExam) {
		this.currentExam = currentExam;
	}

	public Doctor getCurrentDoctor() {
		return currentDoctor;
	}

	public void setCurrentDoctor(Doctor currentDoctor) {
		this.currentDoctor = currentDoctor;
	}

	public Administrator getCurrentAdmin() {
		return currentAdmin;
	}

	public void setCurrentAdmin(Administrator currentAdmin) {
		this.currentAdmin = currentAdmin;
	}
	
	
}
