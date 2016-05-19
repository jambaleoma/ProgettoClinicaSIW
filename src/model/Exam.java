package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;

	@Column (nullable = false)
	private String result;

	@Temporal (TemporalType.DATE)
	private Date examDate;

	@ManyToOne
	private Doctor doctor;

	@ManyToOne
	private Patient patient;

	public Exam() {

		this.code = null;
		this.result = null;
		this.examDate = new Date();
		this.doctor = null;
		this.patient = null;
	}

	public Exam(Long code, String result, Date examDate, Doctor doctor, Patient patient) {
		this.code = code;
		this.result = result;
		this.examDate = examDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	//METODS GETTER & SETTER

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Long getCode() {
		return code;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam"); 
		sb.append(" {code=").append(code); 
		sb.append(", patient='").append(patient); 
		sb.append(", doctor=").append(doctor);
		sb.append(", examDate='").append(examDate);
		sb.append(", result= '").append(result);
		sb.append("}\n");
		return sb.toString();
	}

}
