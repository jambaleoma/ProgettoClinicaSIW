package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import it.uniroma3.model.Typology;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;
import it.uniroma3.model.Patient;
import it.uniroma3.facade.*;

@ManagedBean
public class ExamController {

	@EJB (beanName="examFacade")
	private ExamFacade eFacade;
	
	@EJB (beanName="patientFacade")
	private PatientFacade pFacade;
	
	@EJB (beanName="typologyFacade")
	private TypologyFacade tFacade;
	
	@EJB (beanName="doctorFacade")
	private DoctorFacade dFacade;
	
	@ManagedProperty(value="#{param.code}")
	private Long code;
	private Date examDate;
	private String result;
	private Exam exam;
	private List<Exam> exams;	
	private String message;
	
	@ManagedProperty(value="#{param.typologycode}")
	private Long typologyCode;
	
	@ManagedProperty (value="#{sessionScope['patientController'].patient}")
	private Patient patient;
	
	@ManagedProperty (value="#{sessionScope['doctorController'].doctor}")
	private Doctor doctor;
	
	@ManagedProperty (value="#{sessionScope['typologyController'].typology}")
	private Typology typology;
	
	public String createExam() {
		Exam e = eFacade.create(examDate, typology, patient, doctor);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentExam", e);
		return "index";
	}
	
	public String listExams() {
		if (this.patient==null)
			return "login";
		else{
			this.exams = this.patient.getExams();
		return "myExams";
	}	
	}
	public String findExam(Long code) {
		this.exam = eFacade.getExamByCode(code);
		return "index";
	}
	
	public String setTypologyExamBooking(Typology typology){
		this.typology = typology;
		return "pazientePrenotazione";
	}
	
	public String setPatientBooking(Patient patient){
		this.patient = patient;
		return "doctorBooking";
	}

	public String setDoctorBooking(Doctor doctor){
		this.doctor = doctor;
		return "dataPrenotazione";
	}
	
	public String confermBooking(){
		return "confirmBooking";
	}
	
	//METODS GETTER & SETTER

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getCode() {
		return code;
	}
}