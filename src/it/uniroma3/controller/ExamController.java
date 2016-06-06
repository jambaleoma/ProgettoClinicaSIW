package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.model.Typology;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;
import it.uniroma3.model.Patient;
import it.uniroma3.model.Result;
import it.uniroma3.facade.*;

@ManagedBean(name = "examController")
public class ExamController {

	@EJB
	private ExamFacade eFacade;
	private Long code;
	private Date bookingDate;
	private Date examDate;
	private String result;
	private Typology typology;
	private Patient patient;
	private Doctor doctor;
	private Exam exam;
	private List<Result> results;
	private List<Exam> exams;
	
	private String message;
	
	public String CreateExam() {
		this.exam = eFacade.create(examDate, bookingDate, typology, patient, doctor);
		return "AdminArea";
	}
	
	public String listExams() {
		this.exams = this.eFacade.getAllExams();
		return "allExams";
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
	
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

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