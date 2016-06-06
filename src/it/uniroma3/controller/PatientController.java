package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import it.uniroma3.facade.PatientFacade;
import it.uniroma3.model.Exam;
import it.uniroma3.model.Patient;

@ManagedBean(name="patientController")
public class PatientController {

	@EJB
	private PatientFacade pfacade;

	private String username;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String password;
	private Patient patient;
	private List<Patient> patients;
	private List<Exam> exams;


	public String listExamsPatient(){
		this.patient=this.pfacade.getPatientByUsername(username);
		this.exams=this.patient.getExams();
		if(this.exams!=null)
			return "listExamsPatient";
		else return "patientsArea";

	}

	public String loginPatient() {
		String lp ="login";
		patient = this.pfacade.getPatientByUsername(this.username);
		if(patient!=null)
			if(password.equals(patient.getPassword())){
				lp="patientsArea";
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("patient", patient);
			}
		return lp;
	}

	public String createPatient(){
		this.patient = pfacade.createPatient(username, password, firstName, lastName, dateOfBirth);
		return "patient";
	}

	public String listPatients() {
		this.setPatients(pfacade.getAllPatients());
		return "patients"; 
	}

	public String findPatient(String username) {
		this.patient = pfacade.getPatientByUsername(username);
		return "paziente";
	}

	public PatientFacade getPfacade() {
		return pfacade;
	}

	public void setPfacade(PatientFacade pfacade) {
		this.pfacade = pfacade;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}


}