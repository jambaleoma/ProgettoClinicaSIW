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
import it.uniroma3.persistence.DoctorDao;
import it.uniroma3.persistence.ExamDao;
import it.uniroma3.persistence.PatientDao;
import it.uniroma3.persistence.TypologyDao;

@ManagedBean
public class ExamController {

	@EJB(beanName="eDao")
	private ExamDao eDao;
	
	@EJB(beanName="pDao")
	private PatientDao pDao;
	
	@EJB(beanName="tDao")
	private TypologyDao tDao;
	
	@ManagedProperty(value="#(param.id")
	private Long code;
	
	private String name;
	private String result;
	private String newResult;
	private Date examDate;
	private List<Exam> exams;
	private List<Typology> typologies;
	private List<Doctor> doctors;
	private List<Patient> patients;
	private Exam exam;
	private String message;
	
	@ManagedProperty(value="#{param.typologycode}")
	private Long typologyCode;
	
	@ManagedProperty (value="#{sessionScope['typologyController'].typology}")
	private Typology typology;
	
	@ManagedProperty (value="#{sessionScope['patientController'].patient}")
	private Patient patient;
	
	@ManagedProperty (value="#{sessionScope['doctorController'].doctor}")
	private Doctor doctor;
	
	@ManagedProperty(value="#{sessionScope['currentExam']}")
	private Exam currentExam;
	
	@ManagedProperty(value="#{param.selectedexam}")
	private Long selectedExam;
	
	public String newExam() {
		Exam e = this.eDao.create(null, new Date(), this.typology, this.patient, this.doctor);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentExam", e);
		return "index";
	}
	
	public String listExam() {
			if (this.patient==null)
				return "login";
			else {
				this.exams = this.patient.getExams();
				return "myExams";
			}
	}
	
	public String selectExam() {
		Exam e = this.eDao.findByPrimaryKey(this.selectedExam);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentExam", e);
		return "index";
	}
	
	public String getPatientByCodeExam() {
		try {
			this.exam = this.eDao.findByPrimaryKey(this.code);
			this.patient = this.exam.getPatient();
		} catch (Exception e) {return "loginAdmin"; }
		return "infoPatient";
	}
	
	public String listExams() {
		this.exams = this.eDao.findAll();
		return "allExams";
	}

	private void enterResult() {
		Exam e = this.eDao.findByPrimaryKey(this.selectedExam);
		e.setResult(newResult);
		this.eDao.update(e);
		
	}
	
}
	
	
	
	
	
	
	

